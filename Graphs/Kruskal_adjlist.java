// AUTHOR: Soel Micheletti
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
		else
			return -1; 
	}
}

class Graph{
	int E; 
	Edge[] e; 
	
	public Graph(int E) {
		this.E = E; 
		e = new Edge[E]; 
	}
	
	public void edge(int i, int src, int dest, int weight) {
		e[i] = new Edge(src, dest, weight); 
	}
}

class Node{
	int v; 
	Node parent; 
	
	public Node(int v) {
		this.v = v; 
		this.parent = this; 
	}
}

class UnionFind{
	public Node find(Node a) {
		while(!a.parent.equals(a))
			a = a.parent; 
		return a; 
	}
	
	public void union(Node a, Node b) {
		Node t1 = find(a); 
		Node t2 = find(b); 
		t2.parent = t1; 
	}
}


class Array {
	
	public static void kruskal(Graph G, int V) {
		Edge[] e = G.e; 
		Arrays.sort(e);
		Node[] n = new Node[V]; 
		for(int i = 0; i<n.length; i++)
			n[i] = new Node(i); 
		int r = 0;
		UnionFind U = new UnionFind(); 
		
		for(int i = 0; i<G.E; i++) {
			if(!U.find(n[e[i].src]).equals(U.find(n[e[i].dest]))) {
				U.union(U.find(n[e[i].src]), U.find(n[e[i].dest]));
				r += e[i].weight; 
			}
		}
		
		System.out.println(r); 
		
	}
	
	
	
    public static void main(String[] args) {
        // Create a new Scanner object for reading the input
        Scanner sc = new Scanner(System.in);

        // Read the number of testcases to follow
        int t = sc.nextInt();

        // Iterate over the testcases and solve the problem
        for (int i = 0; i < t; i++) {
            testCase(sc);
        }
    }

    public static void testCase(Scanner sc) {
        // Your main algorithm (solution) should go here
        int V = sc.nextInt(); 
        int E = sc.nextInt(); 
    	Graph g = new Graph(E); 
    	
    	for(int i = 0; i<E; i++) {
    		g.edge(i, sc.nextInt(), sc.nextInt(), sc.nextInt());
    	}
    	
    	kruskal(g, V); 
        
    }
}
