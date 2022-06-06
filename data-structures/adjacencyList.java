// AUTHOR: Soel Micheletti

import java.util.ArrayList;
// The adjacency list, where each element of this list corresponds of a list of edges starting from the node with the corresponding index. 

// We represent edges as Node objects
class Node{
	int dest; 
	int weight; 
	
	public Node(int dest, int weight) {
		this.dest  = dest; 
		this.weight = weight; 
	}
}


// The graph is a list of lists of nodes
// The method edge is used to add edges to the graph
class Graph{
	ArrayList<ArrayList<Node>> L = new ArrayList<ArrayList<Node>>(); 
	int v; 
	
	public Graph(int v) {
		this.v = v; 
		for(int i = 0; i<v; i++)
			L.add(new ArrayList<Node>()); 
	}
	
	public void edge(int start, int end, int weight) {
		L.get(start).add(new Node(end, weight)); 
	}
}
