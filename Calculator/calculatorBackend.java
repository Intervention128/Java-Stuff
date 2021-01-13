import java.util.ArrayList;
public class calculatorBackend {
    public static ArrayList<Integer> primeGen;
    public static int faculty;

    public void primeGenerator(int biggest) {
        ArrayList<Integer> primes = new ArrayList<Integer>();
        boolean hasDivider = false;
        primes.add(2);
        for (int i = 3; i <= biggest; i++) { // i is the actual prime number being tested
            for (int j : primes) { // j is the natural number that i is being tested against
                if (i % j == 0) {
                    hasDivider = true;
                }
                // System.out.println("has divider: " + hasDivider + ", j = " + j + ", i = " + i + ",  j mod i = " + (i % j));
            }
            if (!hasDivider) {
                primes.add(i);
            }
            hasDivider = false;
        }
        // System.out.println(primes);
        primeGen = primes;
    }
    public void calculateFaculty(int n) {
        int result = 1;
        if (n == 0) {
            result = 1;
        }
        else {
            for (int i = n; i > 0; i--) {
                result = result * i;
            }
        }
        faculty = result;
    }
}