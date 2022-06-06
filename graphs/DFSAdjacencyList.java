// AUTHOR: Soel Micheletti

import java.util.ArrayList;
import java.util.Stack;

class Node {
	int dest;
	int weight;

	public Node(int d, int w) {
		dest = d;
		weight = w;
	}
}

class Graph {
	ArrayList<ArrayList<Node>> L = new ArrayList<ArrayList<Node>>();
	int V;

	public Graph(int v) {
		V = v;
		for (int i = 0; i < v; i++) {
			L.add(new ArrayList<Node>());
		}
	}

	public void edge(int src, int dest, int weight) {
		Node n = new Node(dest, weight);
		L.get(src).add(n);
	}
}

class DFS {
	Graph g;
	boolean[] visited;

	public DFS(Graph g) {
		this.g = g;
		visited = new boolean[g.V];
	}

	public void DFS() {
		Stack<Integer> S = new Stack<Integer>();
		S.push(0);

		while (!S.isEmpty()) {
			int w = S.pop();
			if (!visited[w]) {
				System.out.println(w);
				visited[w] = true;
				for (int i = 0; i < g.L.get(w).size(); i++) {
					if (!visited[g.L.get(w).get(i).dest])
						S.push(g.L.get(w).get(i).dest);
				}
			}
		}
	}
}
