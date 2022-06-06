// AUTHOR: Soel Micheletti

public class FloydWarshall{
	public static void floydWahrshall(int[][] g, int V, int s, int t) {
		int[][] d = new int[V][V]; 
		int[][] succ = new int[V][V]; 
		
		for(int i = 0; i<V; i++) {
			for(int j = 0; j<V; j++) {
				d[i][j] = 1030; 
				succ[i][j] = 1030; 
			}
		}
		
		for(int i = 0; i<V; i++) {
			for(int j = 0; j<V; j++) {
				if(g[i][j] != 0) {
					d[i][j] = g[i][j]; 
					succ[i][j] = j; 
				}
			}
		}
		
		for(int i = 0; i<V; i++)
			d[i][i] = 0; 
		
		for(int k = 0; k<V; k++) {
			for(int i = 0; i<V; i++) {
				for(int j = 0; j<V; j++) {
					if(d[i][j]>d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
						succ[i][j] = succ[i][k]; 
					}
				}
			}
		}
		for(int i = 0; i<V; i++) {
			for(int j = 0; j<V; j++) {
				System.out.print(d[i][j] + "\t"); 
			}
			System.out.println(); 
		}
		
		System.out.println(); 
			
		int u = s; 
		
		while(u != t) {
			System.out.println(u);
			u = succ[u][t]; 
		}
		System.out.println(t); 
	}
	
	public static void main(String[]args) {
		int[][] g = {{0, 3, 5, 0, 0, 0}, {1, 0, 4, 0, 4, 1}, {0, 0, 0, 1, -4, 0}, 
				{0, 0, 0, 0, 5, 0}, {0, 1, 0, 2, 0, 0}, {0, 0, 0, 0, 2, 0}}; 
		
		floydWahrshall(g, 6, 0, 3); 
		}
	
} 	
