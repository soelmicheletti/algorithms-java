// AUTHOR: Soel Micheletti
import java.util.Arrays;

public class BellmanFord{
	public static void bellmanFord(int[][] g, int V) {
		int[] d = new int[V]; 
		int[] p = new int[V]; 
		
		for(int i = 0; i<V; i++) {
			d[i] = p[i] = 1030; 
		}
		
		d[0] = 0; 
		p[0] = 0; 
		
		for(int i = 0; i<V-1; i++) {
			for(int j = 0; j<V; j++) {
				for(int k = 0; k<V; k++) {
					if(g[j][k] != 1030) {
						if(d[j] + g[j][k] < d[k]) {
							d[k] = d[j] + g[j][k]; 
							p[k] = j; 
						}
					}
				}
			}
		}
		
		for(int i = 0; i<V; i++) {
			for(int j = 0; j<V; j++) {
				if(g[i][j] != 1030 && d[j]>d[i] + g[i][j])
					System.out.println("Negative cycle"); 
			}
		}
		System.out.println(Arrays.toString(d)); 
		System.out.println(Arrays.toString(p)); 
	}
	
	public static void main(String[]args) {
		int[][] g = {{1030, 10, 1030, 1030, 1030, 8}, 
				{1030, 1030, 1030, 2, 1030, 1030}, 
				{1030, 1, 1030, 1030, 1030, 1030} ,
				{1030, 1030, -2, 1030, 1030, 1030}, 
				{1030, -4, 1030, -1, 1030, 1030}, 
				{1030, 1030, 1030, 1030, 1, 1030}}; 
		bellmanFord(g, 6); 
		}
}
