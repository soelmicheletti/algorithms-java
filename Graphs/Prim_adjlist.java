// AUTHOR: Soel Micheletti

// Taken from an exercise of AW
import java.util.Scanner;
import java.util.ArrayList;
import java.util.PriorityQueue; 

class Edge{
	int dest; 
	int weight; 
	
	public Edge(int a, int b) {
		dest = a; 
		weight = b; 
	}
}


class Graph{
	int V; 
	ArrayList<ArrayList<Edge>> T = new ArrayList<ArrayList<Edge>>();   
	
	public Graph(int v) {
		V = v; 
		for(int i = 0; i<V; i++) {
			T.add(new ArrayList<Edge>()); 
		}
	}
	
	public void edge(int src, int dest, int p) {
		T.get(src).add(new Edge(dest, p)); 
		T.get(dest).add(new Edge(src, p)); 
	}
}

class Node implements Comparable<Node>{
	int v; 
	int p; 
	
	public Node(int v, int p) {
		this.v = v; 
		this.p = p; 
	}
	
	public int compareTo(Node a) {
		if(a.p == p)
			return 0; 
		else if(p>a.p)
			return 1; 
		else
			return -1; 
	}
}


class Prim {
	
	
	public static void prim(Graph g) {
		int[] d = new int[g.V]; 
		int[] p = new int[g.V]; 
		boolean[] in = new boolean[g.V]; 
		
		for(int i = 0; i<g.V; i++) {
			d[i] = Integer.MAX_VALUE; 
			p[i] = -1; 
		}
		
		d[0] = 0; 
		p[0] = -3; 
		
		PriorityQueue<Node> Q = new PriorityQueue<Node>(); 
		Q.add(new Node(0, 0)); 
		
		while(!Q.isEmpty()) {
			int u = Q.poll().v; 
			in[u] = true; 
			
			for(int i = 0; i<g.T.get(u).size(); i++)
				if(!in[g.T.get(u).get(i).dest] && d[g.T.get(u).get(i).dest]>g.T.get(u).get(i).weight) {
					d[g.T.get(u).get(i).dest] = g.T.get(u).get(i).weight; 
					Q.add(new Node(g.T.get(u).get(i).dest, d[g.T.get(u).get(i).dest])); 
				}
		}
		int r = 0; 
		for(int i = 0; i<g.V; i++) {
			r +=d[i]; 
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
        
    	Graph g = new Graph(sc.nextInt()); 
    	int m = sc.nextInt(); 
    	//System.out.println(m);
    	for(int i = 0; i<m; i++) {
    		g.edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
    	}
    	
    	prim(g); 
        
    }
}
