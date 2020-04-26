// AUTHOR: Soel Micheletti
class Node{
	int value; 
	Node next; 
	Node prev; 
	
	public Node(int v) {
		value = v; 
	}
}

class Stack{
	Node first; 
	Node last; 
	int size; 
	
	public void push(int v) {
		Node n = new Node(v);
		if(size == 0) {
			first = last = n; 
			size++; 
		}
		else {
			last.next = n; 
			n.prev = last; 
			last = n; 
			size++; 
		}
	}
	
	public Node pop() {
		Node n = last; 
		if(size == 1) {
			first = last = null; 
			size = 0; 
		}
		else {
			last.prev.next = null; 
			last = last.prev; 
			size--; 
		}
		return n; 
	}
	
	public boolean isEmpty() {
		return size == 0; 
	}
}

class Edge{
	int dest; 
	int weight; 
	Edge next; 
	
	public Edge(int a, int b) {
		dest = a; 
		weight = b; 
	}
}

class List{
	Edge first; 
	Edge last; 
	int size; 
	
	public void add(int dest, int weight) {
		Edge o = new Edge(dest, weight); 
		if(size == 0) {
			first = last = o; 
			size = 1; 
		}
		else {
			last.next = o; 
			last = o; 
			size++; 
		}
	}
}

class Graph{
	List[] L; 
	int V; 
	
	public Graph(int V) {
		this.V = V; 
		L = new List[V]; 
		for(int i = 0; i<V; i++)
			L[i] = new List(); 
	}
	
	public void edge(int src, int dest, int weight) {
		L[src].add(dest, weight); 
	}
}

public class TopologicalSort{
	public static void Topo(Graph g) {
		int[] ord = new int[g.V]; 
		int[] in = new int[g.V]; 
		Stack S = new Stack(); 
		
		for(int i = 0; i<g.V; i++) {
			Edge a = g.L[i].first;
			while(a != null) {
				in[a.dest]++; 
				a = a.next; 
			}
		}
		for(int i = 0; i<g.V; i++) {
			if(in[i] == 0)
				S.push(i);
		}
		int i = 1; 
		while(!S.isEmpty()) {
			int w = S.pop().value;
			ord[w] = i; 
			i++; 
			Edge a = g.L[w].first; 
			while(a != null) {
				in[a.dest]--; 
				if(in[a.dest] == 0)
					S.push(a.dest);
				a = a.next; 
			}
		}
		if(i == g.V + 1) {
			print(ord); 
		}
		else {
			System.out.println("Cycle"); 
		}
	}
	
	public static void print(int[] a) {
		for(int i = 0; i<a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
	
	public static void main(String[]args) {
		Graph g = new Graph(6); 
		g.edge(0, 1, 1);
		g.edge(0, 2, 1);
		g.edge(1, 3, 1);
		g.edge(2, 3, 1);
		g.edge(3, 5, 1);
		g.edge(3, 4, 1);
		g.edge(5, 4, 1);
		Topo(g); 
	}
}
