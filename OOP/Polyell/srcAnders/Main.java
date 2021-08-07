import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type number of horsemen (integer > 1):");
        int totalHorsemen = sc.nextInt(); // not gonna check for stupid inputs.
        ArrayList<Integer> probabilities = new ArrayList<Integer>();
        System.out.println("Now give me the first rider's pushProbability (integer between 1 and 100):"); // the first
        for(int i = 0; i<totalHorsemen - 1; i++) {
            probabilities.add(sc.nextInt());
            System.out.println("Now give me the next rider's pushProbability (integer between 1 and 100):"); // all the others
        }
        probabilities.add(sc.nextInt()); // the last
        Collections.sort(probabilities);
        Tournament tm = new Tournament(probabilities);
        System.out.println("These are the probabilites in order: " + probabilities.toString());
        System.out.println("Now tell me how often to simulate the tournament (integer > 0).");
        int tournamentCount = sc.nextInt();
        System.out.println("Simulating...");
        for(int i = 0; i<tournamentCount; i++) {
            tm.performTournament(tournamentCount == 1);
        }
        sc.close();
    }
}