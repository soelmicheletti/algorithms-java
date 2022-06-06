// AUTHOR: Soel Micheletti

import java.util.ArrayDeque;

public class ShortestPath{
	public static void shortestPath(int[][] g, int s, int t, int V) {
		int[] p = new int[V];
		for(int i = 0; i<V; i++)
			p[i] = -1; 
		int[] l = new int[V]; 
		
		ArrayDeque Q = new ArrayDeque(); 
		Q.add(s); 
		
		while(!Q.isEmpty()) {
			int w = (int) Q.poll(); 
			for(int i = 0; i<V; i++) {
				if(g[w][i] != 0 && p[i] == -1) {
					l[i] = l[w]+1; 
					p[i] = w; 
					Q.add(i); 
				}
			}
		}
		System.out.println("Length of the shortest path between " + s + " and " + t + " is: " + l[t]); 
		int v = t; 
		while(v != -1) {
			System.out.print(v + "  ");
			v = p[v]; 
		}
	}
	
	public static void main(String[] args) {
		int[][] g = {{0, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}}; 
		shortestPath(g, 1, 4, 6); 
	}
}
