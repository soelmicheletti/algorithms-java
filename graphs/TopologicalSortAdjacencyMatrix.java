// AUTHOR: Soel Micheletti

import java.util.Stack;

public class Topo{
	public static void Topo(int[][] g, int V) {
		int[] ord = new int[V]; 
		int[] in = new int[V]; 
		Stack S = new Stack(); 
		
		for(int i = 0; i<V; i++) {
			for(int j = 0; j<V; j++) {
				if(g[i][j] != 0)
					in[j]++; 
			}
		}
		for(int i = 0; i<V; i++) {
			if(in[i] == 0)
				S.add(i); 
		}
		int i = 1; 
		while(!S.isEmpty()) {
			int w = (int) S.pop(); 
			ord[w] = i; 
			i++; 
			for(int j = 0; j<V; j++) {
				if(g[w][j] != 0) {
					in[j]--; 
					if(in[j] == 0)
					S.add(j); 
				}
			}
		}
		if(i == V + 1) {
			print(ord); 
		}
		else {
			System.out.println("Cycle"); 
		}
	}
	
	public static void print(int[] a) {
		for(int i = 0; i<a.length; i++)
			System.out.print(a[i] + "\t"); 
	}
	
	public static void main(String[] args) {
		int[][] g = {{0, 1, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 1},
				{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}};
		Topo(g, 6);
		}
}
