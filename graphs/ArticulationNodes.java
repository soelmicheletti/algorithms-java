// AUTHOR: Soel Micheletti

import java.util.ArrayList;
import java.util.Arrays;

class Node{
	int dest; 
	int weight; 
	
	public Node(int dest, int weight) {
		this.dest = dest; 
		this.weight = weight; 
	}
}

class Graph{
	int V; 
	int E; 
	ArrayList<ArrayList<Node>> L; 
	
	public Graph(int V) {
		this.V = V; 
		L = new ArrayList<ArrayList<Node>>(); 
		for(int i = 0; i<V; i++)
			L.add(new ArrayList<Node>()); 
	}
	
	public void edge(int src, int dest, int weight) {
		E++; 
		L.get(src).add(new Node(dest, weight)); 
	}
}

class Edge{
	int src; 
	int dest; 
	boolean res; 
	
	public Edge(int src, int dest) {
		this.src = src; 
		this.dest = dest; 
		res = false; 
	}
}

public class ArtVertex {
		
	public static void DFS(Graph G, Graph T, int num, int[] dfs, int[] low, boolean[] res, int s) {
		DFSVisit(G, T, num, dfs, low, res, s); 
		if(T.L.get(s).size() >= 2)
			res[s] = true; 
		brucken(G, dfs, low); 
	}
	
	public static int DFSVisit(Graph G, Graph T, int num, int[] dfs, int[] low, boolean[] res, int v) {
		num++; 
		dfs[v] = num; 
		low[v] = dfs[v]; 
		int val = 0; 
		res[v] = false; 
		for(int i = 0; i<G.L.get(v).size(); i++) {
			if(dfs[G.L.get(v).get(i).dest] == 0) {
				T.edge(v, G.L.get(v).get(i).dest, G.L.get(v).get(i).weight);
				val = DFSVisit(G, T, num, dfs, low, res, G.L.get(v).get(i).dest);
				if(val>= dfs[v])
					res[v] = true; 
				low[v] = Math.min(low[v], val); 
			}
			else {
				low[v] = Math.min(low[v], dfs[G.L.get(v).get(i).dest]); 
			}
		}
		return low[v]; 
	}
	
	public static void brucken(Graph G, int[] dfs, int[] low) {
		Edge[] E = new Edge[G.E]; 
		int p = 0; 
		for(int i = 0; i<G.V; i++) {
			for(int j = 0; j<G.L.get(i).size(); j++) {
				E[p] = new Edge(i, G.L.get(i).get(j).dest); 
				p++; 
			}
		}
		
		for(int i = 0; i<E.length; i++) {
			if(low[E[i].dest]>dfs[E[i].src]) {
				E[i].res = true; 
				System.out.println(E[i].src + " -  " + E[i].dest); 
			}
		}
	}
	
	public static void main(String[]args) {
		Graph G = new Graph(12); 
		Graph T = new Graph(12); 
		int num = 0; 
		int[] dfs = new int[G.V]; 
		int[] low = new int[G.V];
		boolean[] res = new boolean[G.V]; 
		
		G.edge(0, 1, 1);
		G.edge(1,  2,  1);
		G.edge(2,  3, 1);
		G.edge(3, 4, 1);
		G.edge(4, 5, 1);
		G.edge(5, 6, 1);
		G.edge(6, 7, 1);
		G.edge(7, 5, 1);
		G.edge(7, 3, 1);
		G.edge(2, 8, 1);
		G.edge(8, 0, 1);
		G.edge(8, 1, 1);
		G.edge(0, 9, 1);
		G.edge(9, 10, 1);
		G.edge(10, 11, 1);
		G.edge(11, 9, 1);
		
		DFS(G, T, num, dfs, low, res, 0); 
		System.out.println(Arrays.toString(res));
	}
}
