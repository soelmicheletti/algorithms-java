// AUTHOR: Soel Micheletti

import java.util.Stack;

class DFS {
	int[][] g;
	int v;
	boolean[] visited;

	public DFS(int[][] g, int v) {
		this.g = g;
		this.v = v;
		visited = new boolean[v];
	}

	public void DFS() {
		Stack<Integer> S = new Stack<Integer>();
		S.add(0);
		while (!S.isEmpty()) {
			int w = S.pop();
			if (!visited[w]) {
				System.out.println(w);
				visited[w] = true;
				for (int i = v - 1; i >= 0; i--) {
					if (g[w][i] != 0 && !visited[i])
						S.push(i);
				}
			}
		}
	}
}
