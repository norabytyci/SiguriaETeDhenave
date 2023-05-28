
import SimplifiedAES.*;

/**
 * Encrypting the plainText with the Key with block ciphers using Simplified AES
 * Decrypted text will be the same as plain text
 */

public class SAES_Demo {
    public static void main(String[] args) {

        String key = "101011";
        String plainText = "1001111101110101";


        // AES
        EncryptionAlgorithm sAES = new SAES();
 
        String enkriptuar = sAES.encrypt(plainText, key);
        String dekriptuar = sAES.decrypt(enkriptuar, key);

        System.out.println("Teksti para enkriptimit:      " + plainText);
        System.out.println("Teksti pas enkriptimit        " + enkriptuar);
        System.out.println("Teksti pas dekriptimit        " + dekriptuar);
      
    }
}
