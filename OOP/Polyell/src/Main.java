import java.util.ArrayList;

/**
 *  The Main class for the "Polyell" tournament-simulation.
 * <p>
 *  This class is responsible for guiding the user through the simulation and performing it.
 * </p>
 */

public class Main {

    /**
     * <p> The main method just starts a test with some numbers.</p>
     * @param args standard args array. not used.
     * @see Horseman
     * @see Tournament
     */

    public static void main(String[] args) {
        // int[] probabilities = {25, 30, 35, 40, 45, 50, 55, 60, 65, 70};
        int[] probabilities = {1, 99};
        // int[] probabilities = {5, 6, 7, 8};
        
        // int tournamentCount = 1;
        // int tournamentCount = 10;
        // int tournamentCount = 100;
        int tournamentCount = 1000;
        
        ArrayList<Integer> probs = new ArrayList<Integer>();
        for (int i : probabilities) {
            probs.add(i);
        }
        Test test = new Test(probs, probs.size());
        test.test(tournamentCount);
    }
}