public class Main {
    public static void main(String[] args) {
        int prime1 = 57397;
        int prime2 = 27733;

        Test test = new Test();
        test.generateKeyPair(prime1, prime2);
        test.generateSignature("./test.txt");
        test.checkSignature("./test.txt"); // this will return the correct signature
        test.checkSignature("./test2.txt"); // this will return the wrong signature
    }
}