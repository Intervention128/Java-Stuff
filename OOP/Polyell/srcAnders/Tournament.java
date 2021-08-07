import java.util.ArrayList;

public class Tournament {
    private ArrayList<Integer> horsemen; // the Horsemen's PushProbabilities as entries
    private int total;

    // constructor
    public Tournament(ArrayList<Integer> horsemen) {
        this.horsemen = horsemen;
        this.total = horsemen.size();
    }

    // perform tournament
    public void performTournament(Boolean log) {
        // System.out.println(this.total); // debug
        // System.out.println(this.horsemen.toString()); // debug
        ArrayList<Integer> knockedOut = new  ArrayList<Integer>(); // keep track of who has been knocked out.
        while(knockedOut.size() < this.total-1) { // as long as there are more than one riders in the arena
            for(int i = 0; i<this.total; i++) { // loop through them
                if(!knockedOut.contains(i)) { // and if they haven't been knocked out yet
                    if(Math.random()*100 <= this.horsemen.get(i)) { // they get a chance at knocking out the next one along
                        int next = (i+1) % this.total; // but who IS the next one along?
                        while(knockedOut.contains(next)) {
                            next = (next + 1) % this.total; // still finding out...
                        }
                        knockedOut.add(next); // there he is! (now was, because he got knocked out hard)
                        // System.out.println(knockedOut.toString()); // debug
                        if(log){System.out.println("Horseman " + i + " knocked out horseman " + next + "!");} // log
                    } else {
                        if(log) {System.out.println("Horseman " + i + " missed!");} // log
                    }
                }
            }
        }
        // announce the winner
        for(int i = 0; i<this.total; i++) {
            if(!knockedOut.contains(i)) {System.out.println("Horseman " + i + " has won the tournament!");}
        }
        
    }
}