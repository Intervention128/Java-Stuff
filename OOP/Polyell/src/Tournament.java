import java.util.ArrayList;

/**
 * 
 * A <code>Tournament</code> object contains a list of horsemen and a list of winning statistics.
 * 
 */

public class Tournament {
    private ArrayList<Horseman> horsemen;
    private ArrayList<Integer> winStats;

    /**
     * Default Tournament constructor.
     * Initiates the "horsemen" and "winStats" lists and adds an entry to winStats for every horseman.
     * 
     * @param horsemen list of Horsemen Objects to carry out the tournament.
     * @see Horseman
     */

    public Tournament(ArrayList<Horseman> horsemen) {
        this.horsemen = horsemen;
        this.winStats = new ArrayList<Integer>();
        for (int i = 0; i<this.horsemen.size(); i++) {
            this.winStats.add(0); // every Horseman has won 0 times so far!
        }
    }

    /**
     * getter for Winner statistics.
     * @return ArrayList with statistics of which horseman (index) won how many times (entry)
     */

    public ArrayList<Integer> getWinStats() {return this.winStats;} // getter for winstats

    /**
     * Performs the actual tournament on a copy of the horsemen list.
     * @return Eventlog of who missed, who hit who, and who won.
     */

    public String performTournament() {
        String log = "";
        ArrayList<Horseman> lineUp = new ArrayList<Horseman>(this.horsemen); // we work on a copy of the horsemen so we can simulate multiple tournaments after one another
        int nextIndex = -1;
        while(lineUp.size()>1) {
            for (int i = 0; i < lineUp.size(); i++) {
                if(Math.random()*100 <= lineUp.get(i).getProbability()) { // in this case, h knocks out the next one along. But who is the next one?
                    nextIndex = (i+1) % lineUp.size(); // there he is!
                    log += "Horseman " + lineUp.get(i).getId() + " knocks out " + lineUp.remove(nextIndex).getId() + "!\n"; // just logging.
                } else {
                    log += "Horseman " + lineUp.get(i).getId() + " missed!\n"; // just logging.
                }
            }
        }
        // announce the winner.
        log += "Horseman " + lineUp.get(0).getId() + " has won the tournament!\n";
        winStats.set(lineUp.get(0).getId(), winStats.get(lineUp.get(0).getId())+1); // increment the number of wins.
        return log;
    }
}