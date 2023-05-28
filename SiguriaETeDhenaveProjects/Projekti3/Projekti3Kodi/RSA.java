import java.math.BigInteger;

public class RSA {

    public static void main(String[] args) {

        BigInteger p = new BigInteger("221671");
        BigInteger q = new BigInteger("228989");
        BigInteger[] parametres = keyParametres(p, q);
        BigInteger[] k_pub = new BigInteger[2];
        BigInteger[] k_pr = new BigInteger[2];

        k_pub[0] = parametres[0];
        k_pub[1] = parametres[1];
        k_pr[0] = parametres[0];
        k_pr[1] = parametres[2];

        String message = "1001";
        String hash = "" + Integer.parseInt(BinaryArithmetic.toBinary(Simplified_SHA.hash(message)), 2);

        BigInteger s = signature(new BigInteger(hash), k_pr);
        BigInteger y = signature(s, k_pub);

        System.out.println(hash + " = " + y);

    }

    public static BigInteger encrypt(BigInteger x, BigInteger[] k_pub) {
        BigInteger n = k_pub[0];
        BigInteger e = k_pub[1];
        BigInteger y = x.modPow(e, n);
        return y;
    }

    public static BigInteger decrypt(BigInteger y, BigInteger[] k_pr) {
        BigInteger n = k_pr[0];
        BigInteger d = k_pr[1];
        BigInteger x = y.modPow(d, n);
        return x;
    }

    public static BigInteger[] keyParametres(BigInteger p, BigInteger q) {

        BigInteger[] a = new BigInteger[3];
        BigInteger n = p.multiply(q);
        BigInteger m = fi(p, q);
        BigInteger e = new BigInteger("0");
        BigInteger i1 = new BigInteger("0");
        BigInteger i = new BigInteger("2");
        boolean stop = false;

        while (!stop) {
            i = i.add(BigInteger.ONE);
            i1 = new BigInteger(String.valueOf(i));
            if (((m.gcd(i1)).compareTo(BigInteger.ONE) == 0)) {
                e = i1;
                stop = true;
            }
        }

        BigInteger d = e.modInverse(m);
        
        a[0] = n;
        a[1] = e;
        a[2] = d;

        return a;
    }

    public static BigInteger signature(BigInteger x, BigInteger[] key) {
        BigInteger m = key[0];
        BigInteger exponent = key[1];
        BigInteger s = x.modPow(exponent, m);
        return s;
    }

    public static BigInteger fi(BigInteger p, BigInteger q) {
        BigInteger one = new BigInteger("1");
        return (p.subtract(one)).multiply(q.subtract(one));
    }

}