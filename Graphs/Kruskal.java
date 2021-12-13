import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
	int src; 
	int dest; 
	int weight; 
	
	public Edge(int src, int dest, int weight) {
		this.src = src; 
		this.dest = dest; 
		this.weight = weight; 
	}
	
	public int compareTo(Edge e) {
		if(weight == e.weight) 
			return 0; 
		else if(weight>e.weight)
			return 1; 
		return -1; 
	}
}
class Graph{
	int V; 
	Edge[] E; 
	
	public Graph(int v, int e) {
		V = v; 
		E = new Edge[e]; 
	}
	
	public void edge(int src, int dest, int weight, int i) {
		E[i] = new Edge(src, dest, weight); 
	}
}

class Node{
	int v; 
	Node prev; 
	
	public Node(int V){
		v = V; 
		prev = this; 
	}
}

class UnionFind{
	public Node find(Node n) {
		while(!n.prev.equals(n)) {
			n = n.prev; 
		}
		return n; 
	}
	
	public void union(Node a, Node b) {
		Node t1 = find(a); 
		Node t2 = find(b); 
		
		t1.prev = t2; 
	}
}

class Main{
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); 
		
		for(int i = 0; i<t; i++)
			solve(sc); 
	}
	
	public static void solve(Scanner sc) {
		int n = sc.nextInt(); 
		int m = sc.nextInt(); 
		Graph G = new Graph(n, m); 
		for(int i = 0; i<m; i++) {
			G.edge(sc.nextInt(), sc.nextInt(), sc.nextInt(), i);
		}
		
		Arrays.sort(G.E);
		Node[] N = new Node[n]; 
		for(int i = 0; i<n; i++) {
			N[i] = new Node(i); 
		}
		int sum = 0;
		UnionFind U = new UnionFind(); 
		for(int i = 0; i<G.E.length; i++) {
			if(U.find(N[G.E[i].src]) != U.find(N[G.E[i].dest])) {
				sum += G.E[i].weight; 
				U.union(N[G.E[i].src], N[G.E[i].dest]);
			}
		}
		System.out.println(sum); 
	}
}
