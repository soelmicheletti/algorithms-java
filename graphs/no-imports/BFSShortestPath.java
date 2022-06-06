// AUTHOR: Soel Micheletti


// This code computes the shortest path in linear time in a graph with uniform weights
class Node{
	int value; 
	Node next; 
	
	public Node(int v) {
		value = v; 
	}
}

class Queue{
	Node first; 
	Node last; 
	int size; 
	
	public boolean isEmpty() {
		return size == 0; 
	}
	
	public void enqueue(int v) {
		Node n = new Node(v); 
		if(isEmpty()) {
			first = last = n; 
			size = 1; 
		}
		else {
			last.next = n; 
			last = n; 
			size++; 
		}
	}
	
	public Node dequeue() {
		Node n = first; 
		if(size == 1) {
			first = last = null; 
			size = 0; 
		}
		else {
			first = first.next; 
			size--; 
		}
		return n; 
	}
}

class Edge{
	int dest; 
	int weight; 
	Edge next; 
	
	public Edge(int dest, int weight) {
		this.dest = dest; 
		this.weight = weight; 
	}
}

class List{
	Edge first; 
	Edge last; 
	int size; 
	
	public void add(int dest, int weight) {
		Edge n = new Edge(dest, weight); 
		if(size == 0) {
			first = last = n; 
			size = 1; 
		}
		else {
			last.next = n; 
			last = n; 
			size++; 
		}
	}
}

class Graph{
	 List[] L; 
	 int V; 
	 
	 public Graph(int v) {
		 V = v; 
		 L = new List[V]; 
		 for(int i = 0; i<v; i++)
			 L[i] = new List(); 
	 }
	 
	 public void edge(int src, int dest, int weight) {
		 L[src].add(dest, weight); 
	 }
 }

public class ShortestPath{
	public static void shortestPath(Graph g, int s, int t) {
		int[] p = new int[g.V]; 
		for(int i = 0; i<p.length; i++) {
			p[i] = -1; 
		}
		int[] l = new int[g.V]; 
		Queue Q = new Queue(); 
		Q.enqueue(s);
		
		while(!Q.isEmpty()) {
			int w = Q.dequeue().value; 
			Edge a = g.L[w].first; 
			while(a != null) {
				if(p[a.dest] == -1) {
					p[a.dest] = w; 
					l[a.dest] = l[w] + 1; 
					Q.enqueue(a.dest);
				}
				a = a.next; 
			}
		}
		
		System.out.println("Length of the shortest path between " + s + " and " + t + " is: " + l[t]); 
		int v = t; 
		System.out.println("The shortest path is: "); 
		while(v != -1) {
			System.out.print(v + "  "); 
			v = p[v]; 
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(6); 
		g.edge(0, 1, 1);
		g.edge(0, 2, 1);
		g.edge(5, 4, 1);
		g.edge(3, 5, 1);
		g.edge(1, 3, 1);
		g.edge(2, 3, 1);
		g.edge(3, 4, 1);
		
		shortestPath(g, 1, 5); 
	}
}
