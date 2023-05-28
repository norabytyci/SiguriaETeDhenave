import java.math.BigInteger;

public class Attack_RSA {
    public static void main(String[] args) {
        BigInteger n = new BigInteger("797306344204135429053419");
        BigInteger e = new BigInteger("920419823");
        Attack_RSA.testParametres(Attack_RSA.fourthRoot(n, e));
    }

    public static BigInteger[] fourthRoot(BigInteger n, BigInteger e) {
        BigInteger one = new BigInteger("1");
        BigInteger A = (n.sqrt()).add(one);
        BigInteger x = ((A.pow(2)).subtract(n)).sqrt();
        BigInteger p = A.subtract(x);
        BigInteger q = A.add(x);
        BigInteger fi = (p.subtract(one)).multiply(q.subtract(one));
        BigInteger d = e.modInverse(fi);
        return new BigInteger[] { p, q, d, fi, n, e };
    }

    public static void testParametres(BigInteger[] rsa_parametres) {
        BigInteger p = rsa_parametres[0];
        BigInteger q = rsa_parametres[1];
        BigInteger d = rsa_parametres[2];
        BigInteger fi = rsa_parametres[3];
        BigInteger n = rsa_parametres[4];
        BigInteger e = rsa_parametres[5];

        System.out.println("N = " + n);
        System.out.println("p = " + p);
        System.out.println("q = " + q);
        System.out.println("fi(n) = " + fi);
        System.out.println("e = " + e);
        System.out.println("d = " + d);
        
        boolean b1 = booleanEqual((p.multiply(q)).compareTo(n));
        boolean b2 = booleanEqual(((d.multiply(e).mod(fi)).compareTo( BigInteger.ONE)));
        System.out.println("p*q = n  " + b1);
        System.out.println("d*e = 1 mod fi(n) " + b2);
    }

    public static boolean booleanEqual(int x) {
        if (x == 0) {
            return true;
        } else
            return false;
    }
}
