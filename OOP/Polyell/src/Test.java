import java.util.ArrayList;
import java.util.Collections;

public class Test {
    private ArrayList<Integer> probabilities;
    private ArrayList<Horseman> horsemen;

    public Test(ArrayList<Integer> probabilities, int horsemanCount) {
        this.probabilities = probabilities;
        this.horsemen = new ArrayList<Horseman>();
        for (int i=0; i< horsemanCount; i++) {
            this.horsemen.add(new Horseman(i, probabilities.get(i)));
        }
    }

    public void test(int tournamentCount) {
        Collections.sort(this.probabilities); // sort them
        System.out.println("These are the probabilites in order: " + this.probabilities);
        Tournament tm = new Tournament(this.horsemen);
        String log = new String();
        for(int i = 0; i<tournamentCount; i++) {
            log = tm.performTournament();
        }
        if (tournamentCount > 1) {
            winStats(tm, tournamentCount);
        } else {
            System.out.println(log);
        }
    }

    public void winStats(Tournament tm, int tournamentCount) {
        ArrayList<Integer> winStats = tm.getWinStats();
        System.out.println("\u001B[33mWinner statistics:");
        for(int w : winStats) {
            int percentage = Math.round(100*w/tournamentCount);
            System.out.println("Horseman "+ winStats.indexOf(w) + " has won " + w + " times in total. That is about " + percentage + " percent.");
        }
        System.out.println("\u001B[0m");
    }
}