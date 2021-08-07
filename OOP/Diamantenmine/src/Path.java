package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * A <code>Path</code> consists of one or more nodes and represents a way through a graph from one node to another.
 * @see Node
 * @see Graph
 */

public class Path implements Comparable<Path> {
	private ArrayList<Node> path = new ArrayList<Node>();
	
 	/**
 	 * Standard constructor
 	 */
 	public Path() {}
 	/**
 	 * constructs a Path with one node
 	 * @param node node to add to the path
 	 */
 	public Path(Node node) {this.path.add(node);}
	/**
	 * constructs a path with a list of nodes
	 * @param path list of nodes to set the path to
	 */
	public Path(ArrayList<Node> path) {this.path = path;}
	/**
	 * copy constructor. Copies an existing path into another.
	 * @param p the path to be cloned.
	 */
	@SuppressWarnings("unchecked")
	public Path(Path p) {
		this.path = (ArrayList<Node>)p.asList().clone();
	}
	
	/**
	 * @return a list of nodes that are on the path.
	 */
	public ArrayList<Node> asList() {return this.path;}
	/**
	 * @return the node where the path starts
	 */
	public Node from() {return this.path.get(0);}
	/**
	 * @return the node where the path ends
	 */
	public Node to() {return this.path.get(this.path.size()-1);}
	/**
	 * @return the length of the path
	 */
	public int getLength() {return this.path.size();}
	/**
	 * adds a single node to the path
	 * @param n node to add to the path
	 * @return the changed path
	 */
	public Path addNode(Node n) {
		this.path.add(n);
		return this;
	}
	/**
	 * adds an entire path to the path
	 * @param p path to add to the path
	 * @return the changed path
	 */
	public Path addPath(Path p) {
		for(Node n : p.asList()) this.path.add(n);
		return this;
	}
	
	/**
	 * Auto constructor for a path that goes trough a graph, starts at a node and ends at either a DIAMOND-type or NULL-type node.
	 * @param g the graph the path goes through.
	 * @param start the node the path starts at
	 * @return the newly constructed path.
	 */
	public static Path getShortestPath(Graph g, Node start) {
		return bfs(g, new ArrayList<Path>(Arrays.asList(new Path(start))), new ArrayList<Node>(Arrays.asList(start)), new ArrayList<Path>());
	}
	
	
	/**
	 * Breadth-first-search. Finds shortest path from a given node to either a DIAMOND-type or a NULL-type node.
	 * @param g the graph for the path to go through
	 * @param q a queue of paths to check
	 * @param visited a list of paths already checked
	 * @param acc paths that go to the right type of node
	 * @return shortest eligible path
	 */
	private static Path bfs(Graph g, ArrayList<Path> q, ArrayList<Node> visited, ArrayList<Path> acc) {
		if(q.isEmpty()) {
			while(acc.size()>0) {
				Path result = Collections.min(acc);
				boolean ok = true;
				for (Node n : result.asList()) {
					if(g.plannedNodes.contains(n) && !(n == result.from())) {
						acc.remove(result);
						ok = false;
						break;
					}
				}
				if(ok) {
					for(Node n : result.asList()) {
						if(n.type == Node.Type.EMPTY) g.plannedNodes.add(n);
					}
					if(result.to().type == Node.Type.DIAMOND) g.plannedNodes.add(result.to());
					return result;
				}
			}
			return null;
		}
		Path currentPath = q.remove(0);
		Node currentNode = currentPath.to();
		for(Node n : g.neighbours(currentNode)) {
			if(!visited.contains(n)) {
				visited.add(n);
				q.add(new Path(currentPath).addNode(n));
			}
		}
		for(Path p : q) {
			if(p.to().type == Node.Type.DIAMOND && !acc.contains(p)) acc.add(p);
			if(p.to().type == Node.Type.NULL && !acc.contains(p)) acc.add(p);
		}
		return bfs(g, q, visited, acc);
	}
	
	/**
	 * compareTo-implementation for bfs to find the actual shortest path.
	 * @return an integer between -1 and 1
	 */
	@Override
	public int compareTo(Path p) {
		return this.path.size()>p.getLength() ? 1 : this.path.size()<p.getLength() ? -1 : 0;
	}
	
	/**
	 * toString method.
	 * @return descriptive string
	 */
	@Override
	public String toString() {
		return "Path " + path;
	}
}