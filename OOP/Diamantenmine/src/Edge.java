package src;
/**
 * An <code>Edge</code> of a graph. Keeps track of where it starts and ends.
 * @see Graph
 *
 */
public class Edge {
	private Node start;
	private Node end;
	
	/**
	 * @param start The Node at which the Edge starts
	 * @param end The Node at which the Edge ends
	 */
	public Edge(Node start, Node end) {
		this.start = start;
		this.end = end;
	}
	
	/**
	 * @return The Node at which the Edge starts
	 */
	public Node getStart() {return start;}
	/**
	 * @return The Node at which the Edge ends
	 */
	public Node getEnd() {return end;}

	/**
	 * @param start Set the Node at which the Edge starts
	 * @return The changed Edge
	 */
	public Edge setStart(Node start) {
		this.start = start;
		return this;
	}
	/**
	 * @param end Set the Node at which the Edge ends 
	 * @return The changed Edge
	 */
	public Edge setEnd(Node end) {
		this.end = end;
		return this;
	}

	/**
	 * toString Method.
	 * @return a descriptive String.
	 */
	@Override
	public String toString() {
		return "Edge [from=" + start + ", to=" + end + "]";
	}
}
