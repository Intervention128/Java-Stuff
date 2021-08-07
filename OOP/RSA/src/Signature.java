import java.io.BufferedReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The <code>Signature</code> class is responsible for checking and signing messages from a given path using the MD5 checksum algorithm.
 */

public class Signature {
    private int key1, key2;
    private BigInteger signature;

    /**
     * Constructor to use if user wants to sign a message.
     * @param key1 first part of private key
     * @param key2 second part of private key
     */
    public Signature(int key1, int key2) { // use to Sign a message
        this.key1 = key1;
        this.key2 = key2;
    }

    /**
     * Constructor to use if user wants to check a signed message against a given signature
     * @param key1 first part of public key
     * @param key2 second part of public key
     * @param signature the signature to check against
     */
    public Signature(int key1, int key2, BigInteger signature) { // use to check signature of message
        this.key1 = key1;
        this.key2 = key2;
        this.signature = signature;
    }

    /**
     * signs the text from the file at path using key1 and key2
     * @param path the path to the text
     * @return BigInteger the signature calculated from the checksum
     */
    public BigInteger sign(String path) { // returns the signature signed with the key given to the instance.
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while(line != null) {
                sb.append(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BigInteger checksum = checksum(sb.toString());
        BigInteger result = checksum.modPow(BigInteger.valueOf(key1), BigInteger.valueOf(key2));
        return result;
    }

    /**
     * checks a given signature to the file at path
     * @param path the path to the file to check
     * @return Boolean correctness of the file (true if correct, false if not)
     */
    public Boolean checkSignature(String path) { // if true, the text hasn't been altered.
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while(line != null) {
                sb.append(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BigInteger calculated_checksum = checksum(sb.toString());
        BigInteger shouldBe_checksum = this.signature.modPow(BigInteger.valueOf(key1), BigInteger.valueOf(key2));
        return calculated_checksum.equals(shouldBe_checksum);
    }

    // generate checksum
    /**
     * generates a checksum using the MD5 algorithm.
     * @param msg the message to calculate a checksum for
     * @return BigInteger the checksum
     */
    private BigInteger checksum(String msg) { // generates a MD5 checksum.
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(msg.getBytes());
            byte[] cheat = new byte[2];
            cheat[0] = messageDigest[0];
            cheat[1] = messageDigest[1];
            BigInteger out = new BigInteger(1, cheat);
            return out;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}