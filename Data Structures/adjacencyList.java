import java.util.ArrayList;

class Node{
	int dest; 
	int weight; 
	
	public Node(int dest, int weight) {
		this.dest  = dest; 
		this.weight = weight; 
	}
}



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
