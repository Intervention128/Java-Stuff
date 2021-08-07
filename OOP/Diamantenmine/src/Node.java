package src;

/**
 * A <code>Node</code> belongs to a graph. Has a type and knows if it was visited or not.
 * @see Graph
 */

public class Node {
	/**
	 * There are different kinds of nodes.
	 */
	enum Type {
        NULL,
        EMPTY,
        DIAMOND
    }

    public Type type;
    private Boolean visited;

    /**
     * Standard constructor. Constructs a node of type NULL
     */
    public Node() {
    	this.type = Type.NULL;
    } 
    /**
     * Constructor for not-NULL-type nodes.
     * @param containsDiamond if the type is DIAMOND or EMPTY.
     */
    public Node(Boolean containsDiamond) {
    	this.type = containsDiamond ? Type.DIAMOND : Type.EMPTY;
    	this.visited = false;
    }
    
    /**
     * @return if the node was visited of not.
     */
    public Boolean getVisited() {return this.visited;}
    /**
     * setter for the visited property.
     * @param visited if the node was visited.
     * @return the changed node.
     */
    public Node isVisited(Boolean visited) {
        this.visited = visited;
        return this;
    }
    
    /**
     * @param t the type to set the node to.
     * @return the changed node.
     */
    public Node setType(Type t) {
    	this.type = t;
    	return this;
    }
    /**
     * toString method.
     * @return descriptive string.
     */
    @Override
	public String toString() {
		return "Node [type=" + type + "visited=" + visited + "]";
	}
}
