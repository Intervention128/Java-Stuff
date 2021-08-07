import java.math.BigInteger;

public class Test {
    private int[] privateKey = new int[2];
    private int[] publicKey = new int[2];
    private BigInteger signature;

    public Test() {}

    public void generateKeyPair(int p, int q) {
        RSA rsa = new RSA(p,q);
        rsa.generateKeyPair();
        this.publicKey[0] = rsa.getE();
        this.privateKey[0] = rsa.getD();
        this.privateKey[1] = rsa.getG();
        this.publicKey[1] = rsa.getG();
        System.out.println(rsa);
    }

    public void generateSignature(String path) {
        Signature sgn = new Signature(this.privateKey[0], this.privateKey[1]);
        this.signature = sgn.sign(path);
        System.out.println("The signature is: "+this.signature);
    }

    public void checkSignature(String path) {
        Signature sgn = new Signature(this.publicKey[0], this.publicKey[1], this.signature);
        System.out.println(sgn.checkSignature(path) ? "The message was correct!" : "The message was altered!");
    }
}