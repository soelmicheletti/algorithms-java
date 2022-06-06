// AUTHOR: Soel Micheletti
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
	ArrayList<ArrayList<Edge>> L = new ArrayList<ArrayList<Edge>>(); 
	
	public Graph(int v) {
		V = v; 
		for(int i = 0; i<v; i++)
			L.add(new ArrayList<Edge>()); 
	}
	
	public void edge(int src, int dest, int weight) {
		L.get(src).add(new Edge(dest, weight)); 
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
		
		for(int i = 0; i<g.V; i++) {
			for(int j = 0; j<g.L.get(i).size(); j++) {
				d[i][g.L.get(i).get(j).dest] = g.L.get(i).get(j).weight; 
				succ[i][g.L.get(i).get(j).dest] = g.L.get(i).get(j).dest; 
			}
		}
		
		for(int i = 0; i<g.V; i++) {
			d[i][i] = 0; 
			succ[i][i] = Integer.MAX_VALUE; 
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
