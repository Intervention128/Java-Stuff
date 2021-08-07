package src;
import java.util.ArrayList;

/**
 * A <code>Mine</code> contains a plan and automatically constructs a graph out of it. It can then be used to solve the problem. 
 * @see Graph
 * @see Node
 */

public class Mine {
	private Graph graph;
	private Node[][] plan;
	
	/**
	 * Standard constructor. Also constructs a new graph out of the plan.
	 * @param plan 2-dimensional array of nodes that contain the plan.
	 */
	public Mine(Node[][] plan) {
		this.plan = plan;
		this.graph = Graph.fromNodeArray(plan);
	}
	
	/**
	 * prints an overview of the mine to console.
	 */
	public void printGraph() {
		System.out.println("");
		for(int i=0; i<plan.length; i++) {
	    	for (int j=0; j<plan[i].length; j++) {
	    		System.out.print(plan[i][j].type == Node.Type.DIAMOND ? "x" : plan[i][j].type == Node.Type.EMPTY ? "E" : "0");
	    	}
	    	System.out.println();
	    }
	}
	
	/**
	 * solves the problem and prints the solution to console.
	 */
	public void printFinalPath() {
		ArrayList<Node> diamonds = new ArrayList<Node>();
		for(Node n : this.graph.getNodes()) {
			if(n.type == Node.Type.DIAMOND) diamonds.add(n);
		}
		Path finalPath = new Path();
		for(Node n : diamonds) {
			Path p = Path.getShortestPath(this.graph, n);
			finalPath.addPath(p);
		}
		for(Node n : finalPath.asList()) n.isVisited(true);
		for(int i=0; i<plan.length; i++) {
        	for (int j=0; j<plan[i].length; j++) {
        		System.out.print(plan[i][j].type == Node.Type.NULL ? "0" : plan[i][j].getVisited() ? "V" : "E");
        	}
        	System.out.println();
        }
	}
}


