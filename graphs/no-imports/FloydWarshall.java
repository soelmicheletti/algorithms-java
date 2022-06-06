// AUTHOR: Soel Micheletti

class Node{
	int dest; 
	int weight; 
	Node next; 
	
	public Node(int dest, int weight) {
		this.dest = dest; 
		this.weight = weight; 
	}
}

class List{
	Node first; 
	Node last; 
	int size; 
	
	public void add(int dest, int weight) {
		Node n = new Node(dest, weight); 
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
	int V; 
	List[] L; 
	
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


public class FloydWarshall{
	
	public static void floydWahrshall(Graph g, int s, int t) {
		int[][] d = new int[g.V][g.V]; 
		int[][] succ = new int[g.V][g.V]; 
		
		for(int i = 0; i<g.V; i++) {
			for(int j = 0; j<g.V; j++)
				d[i][j] = succ[i][j] = 1030; 
		}
		
		for(int i = 0; i<g.L.length; i++) {
			Node a = g.L[i].first; 
			while(a != null) {
				d[i][a.dest] = a.weight; 
				succ[i][a.dest] = a.dest; 
				a = a.next; 
			}
		}
		
		for(int i = 0; i<g.V; i++) {
			d[i][i] = 0; 
			succ[i][i] = i; 
		}
		
		for(int k = 0; k<g.V; k++) {
			for(int i = 0; i<g.V; i++) {
				for(int j = 0; j<g.V; j++) {
					if(d[i][j]>d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j]; 
						succ[i][j] = succ[i][k]; 
					}
				}
			}
		}
		
		for(int i = 0; i<g.V; i++) {
			for(int j = 0; j<g.V; j++) {
				System.out.print(d[i][j] + "\t");
			}
			System.out.println(); 
		}
		System.out.println(); 
		int u = s; 
		while( u != t) {
			System.out.println(u); 
			u = succ[u][t]; 
		}
		System.out.println(t); 
	}
	
	public static void main(String[]args) {
		Graph g = new Graph(6); 
		g.edge(0, 1, 3);
		g.edge(0, 2, 5);
		g.edge(1, 0, 1);
		g.edge(1, 2, 4);
		g.edge(1, 4, 4);
		g.edge(1, 5, 1);
		g.edge(2, 3, 1);
		g.edge(2, 4, -4);
		g.edge(3, 4, 5);
		g.edge(4, 1, 1);
		g.edge(4, 3, 2);
		g.edge(5, 4, 2);
		
		floydWahrshall(g, 0, 3); 
	}
}
