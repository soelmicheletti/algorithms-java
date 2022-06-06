// AUTHOR: Soel Micheletti

import java.util.Arrays;
import java.util.PriorityQueue;

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
		if(p<a.p)
			return -1; 
		return 1; 
	}
}

public class Dijkstra{
	public static void dijkstra(int[][] g, int s, int V) {
		int[] p = new int[V]; 
		int[] d = new int[V]; 
		
		for(int i = 0; i<V; i++) {
			p[i] = -1; 
			d[i] = Integer.MAX_VALUE; 
		}
		
		p[s] = -3; 
		d[s] = 0; 
		PriorityQueue<Node> Q = new PriorityQueue<Node>(); 
		Q.add(new Node(s, 0)); 
		
		while(!Q.isEmpty()) {
			int w = Q.poll().v; 
			for(int i = 0; i<V; i++) {
				if(g[w][i] != 0) {
					if(p[i] == -1) {
						d[i] = d[w] + g[w][i];
						p[i] = w; 
						Q.add(new Node(i, d[i])); 
					}
					else if(d[w] + g[w][i]<d[i]) {
						int o = d[i]; 
						d[i] = d[w] + g[w][i];
						p[i] = w; 
						Q.remove(new Node(i,o)); 
						Q.add(new Node(i, d[i])); 
					}
				}
			}
		}
		System.out.println(Arrays.toString(d)); 
		System.out.println(Arrays.toString(p)); 
	}
	
	public static void main(String[]args) {
		int[][] g = {{0, 1, 3, 0}, {1, 0, 2, 3}, {3, 2, 0, 4}, {5, 3, 4, 0}}; 
		dijkstra(g, 0, 4);
	}
}
