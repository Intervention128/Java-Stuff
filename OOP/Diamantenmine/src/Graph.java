package src;

import java.util.ArrayList;

/**
 * A <code>Graph</code> contains nodes and edges.
 * @see Node
 * @see Edge
 */

public class Graph {
	private ArrayList<Node> nodes = new ArrayList<Node>();
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	public ArrayList<Node> plannedNodes = new ArrayList<Node>();
	
	/**
	 * Standard constructor.
	 */
	public Graph() {}
	
	/**
	 * @return list of all nodes in the graph.
	 */
	public ArrayList<Node> getNodes() {return nodes;}
	
	/**
	 * @param start node to start the edge from
	 * @param end node to end the edge at
	 * @return the changed graph
	 */
	public Graph addEdge(Node start, Node end) {
		if(this.nodes.contains(start) && this.nodes.contains(end)) {
			this.edges.add(new Edge(start, end));
		}
		return this;
	}
	
	/**
	 * @param node node to add to the graph
	 * @return the changed graph
	 */
	public Graph addNode(Node node) {
		if(!this.nodes.contains(node)) {this.nodes.add(node);}
		return this;
	}
	
	/**
	 * @param n node to get neighbouring nodes of
	 * @return a list of neighbouring nodes 
	 */
	public ArrayList<Node> neighbours(Node n) {
		ArrayList<Node> neighbours = new ArrayList<Node>();
		for(Edge e : this.edges) {
			if(e.getStart() == n) neighbours.add(e.getEnd());
			if(e.getEnd() == n) neighbours.add(e.getStart());
		}
		return neighbours;
	}
	
	/**
	 * @param array 2 dimensional array of nodes to construct a graph out of. Basically an auto constructor.
	 * @return the newly constructed graph.
	 */
	public static Graph fromNodeArray(Node[][] array) {
		Graph g = new Graph();
		for(int i=0; i<array[0].length; i++) {
			for(int j=0; j<array[i].length; j++) {
				g.addNode(array[i][j]);
			}
		}
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array[i].length; j++) {
				if(j!=array[i].length-1) {
					g.addEdge(array[i][j], array[i][j+1]);
				}
				if(i!=array.length-1) {
					g.addEdge(array[i][j], array[i+1][j]);
				}
			}
		}
		return g;
	}

	/**
	 * toString method.
	 * @return a descriptive string.
	 */
	@Override
	public String toString() {
		return "Graph [nodes=" + nodes + ", edges=" + edges + "]";
	}
}
