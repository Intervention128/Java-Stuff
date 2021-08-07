/**
 * The <code>RSA</code> class generates a keypair using two prime numbers.
 */

public class RSA {    
    private int p, q, g, d; // numbers for keys
    private int e = 2;

    /**
     * Default RSA constructor.
     * @param p the first prime
     * @param q the second prime
     */
    RSA(int p, int q) {
        this.p = p;
        this.q = q;
        this.g = p * q;
    }

    /**
     * @return int the second part of both the private and the public key
     */
    public int getG() {return this.g;} // second part of both keys
    /**
     * @return int the first part of the private key
     */
    public int getD() {return this.d;} // first part of private key
    /**
     * @return int the first part of the public key
     */
    public int getE() {return this.e;} // first part of public key

    /**
     * Generates the keypair.
     */
    public void generateKeyPair() {
        int phi = (this.p - 1) * (this.q - 1);
        while(extendedEuclidian(e, phi) != 1) {e++;}
        if(this.d < 0) {this.d = this.d + phi;}
    }

    /**
     * The extended euclidian algorithm calculates the greatest common divisor and integers s, t so that gcd(a,b) = as+bt.
     * @param a 
     * @param b
     * @return int gcd of a, b.
     */
    private int extendedEuclidian(int a, int b) {
        int x1, x2;
        int y1, y2;
        x1 = y2 = 1;
        x2 = y1 = 0;
        int tempr, tempq, tempx, tempy;
        int loopIndex = 0;
        while (b != 0) {
            tempr = a % b;
            tempq = Math.floorDiv(a, b);

            a = b;
            b = tempr;

            tempx = x2;
            x2 = tempq * x2 + x1;
            x1 = tempx;

            tempy = y2;
            y2 = tempq * y2 + y1;
            y1 = tempy;

            loopIndex++;
        }
        this.d = x1 * (int)Math.pow(-1, loopIndex);
        return a; // now gcd(a,b) = this.s * a + this.t * b
    }
    @Override
    /**
     * @return String System out for public and private keys.
     */
    public String toString() {
        String line1 = "Your public key is: {" + this.e + ", " + this.g + "}.\n";
        String line2 = "Your private key is: {" + this.d + ", " + this.g + "}.";
        return line1 + line2;
    }
}