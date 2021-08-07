/**
 * 
 * A <code>Horseman</code> object contains the horseman's ID and probability with which they will knock out the rider in front of them.
 */

public class Horseman {
    private int id;
    private int probability;

    /**
     * Default constructor of a horseman object.
     * @param id The ID of the horseman
     * @param probability The probability with which they will knock out the rider in front of them
     */

    public Horseman(int id, int probability) {
        this.id = id;
        this.probability = probability;
    }

    /**
     * 
     * @return the horseman's ID
     */

    public int getId() {return this.id;}
    /**
     * 
     * @return Integer between 1 and 100
     */
    public int getProbability() {return this.probability;}
}