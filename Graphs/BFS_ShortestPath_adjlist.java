// AUTHOR: Soel Micheletti
import java.util.ArrayDeque;
import java.util.ArrayList;

class Edge{
	int dest; 
	int weight; 
	
	public Edge(int dest, int weight) {
		this.dest = dest; 
		this.weight = weight; 
	}
}

class Graph{
	int V; 
	ArrayList<ArrayList<Edge>> L; 
	
	public Graph(int v) {
		V = v; 
		L = new ArrayList<ArrayList<Edge>>(); 
		for(int i = 0; i<v; i++)
			L.add(new ArrayList<Edge>());
	}
	
	public void edge(int src, int dest, int weight) {
		L.get(src).add(new Edge(dest, weight)); 
	}
}

public class ShortestPath{
	public static void shortestPath(Graph g, int s, int t) {
		int[] p = new int[g.V]; 
		for(int i = 0; i<g.V; i++)
			p[i] = -1; 
		int[] l = new int[g.V];
		ArrayDeque Q = new ArrayDeque(); 
		Q.add(s); 
		
		while(!Q.isEmpty()) {
			int w = (int) Q.poll(); 
			for(int i = 0; i<g.L.get(w).size(); i++) {
				if(p[g.L.get(w).get(i).dest] == -1) {
					p[g.L.get(w).get(i).dest] = w; 
					l[g.L.get(w).get(i).dest] = l[w] + 1; 
					Q.add(g.L.get(w).get(i).dest); 
				}
			}
		}
		System.out.println("Length of the shortest path is: " + l[t]); 
		int v = t; 
		while(v != -1) {
			System.out.print(v + "  ");
			v = p[v]; 
		}
	}
	
	public static void main(String[]args) {
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
