// AUTHOR: Soel Micheletti

import java.util.ArrayDeque;
import java.util.ArrayList;

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
		for (int i = 0; i < v; i++)
			L.add(new ArrayList<Node>());
	}

	public void edge(int src, int dest, int weight) {
		L.get(src).add(new Node(dest, weight));
	}
}

class BFS {
	Graph g;
	boolean[] a;
	boolean[] v;

	public BFS(Graph g) {
		this.g = g;
		a = new boolean[g.V];
		v = new boolean[g.V];
	}

	public void BFS() {
		ArrayDeque Q = new ArrayDeque();
		Q.add(0);
		a[0] = true;

		while (!Q.isEmpty()) {
			int w = (int) Q.poll();
			System.out.println(w);
			v[w] = true;

			for (int i = 0; i < g.L.get(w).size(); i++) {
				if (!a[g.L.get(w).get(i).dest] && !v[g.L.get(w).get(i).dest]) {
					a[g.L.get(w).get(i).dest] = true;
					Q.add(g.L.get(w).get(i).dest);
				}
			}

		}
	}
}
