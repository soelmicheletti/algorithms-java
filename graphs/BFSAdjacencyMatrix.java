// AUTHOR: Soel Micheletti
import java.util.ArrayDeque;
import java.util.Queue;

class BFS {
	int[][] g;
	int v;
	boolean[] a;
	boolean[] visited;

	public BFS(int[][] g, int v) {
		this.g = g;
		this.v = v;
		a = new boolean[v];
		visited = new boolean[v];
	}

	public void BFS() {
		Queue Q = new ArrayDeque();
		Q.add(0);
		a[0] = true;

		while (!Q.isEmpty()) {
			int w = (int) Q.poll();
			System.out.println(w);
			visited[w] = true;
			for (int i = 0; i < v; i++) {
				if (g[w][i] != 0 && !visited[i] && !a[i]) {
					a[i] = true;
					Q.add(i);
				}
			}
		}
	}
}
