// AUTHOR: Soel Micheletti

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int value;
	int p;

	public Node(int value, int p) {
		this.value = value;
		this.p = p;
	}

	public int compareTo(Node a) {
		if (a.p == p)
			return 0;
		else if (p > a.p)
			return 1;
		return -1;
	}
}

class Edge {
	int dest;
	int weight;

	public Edge(int d, int w) {
		dest = d;
		weight = w;
	}
}

class Graph {
	int V;
	ArrayList<ArrayList<Edge>> L = new ArrayList<ArrayList<Edge>>();

	public Graph(int v) {
		V = v;
		for (int i = 0; i < v; i++)
			L.add(new ArrayList<Edge>());
	}

	public void edge(int src, int dest, int weight) {
		L.get(src).add(new Edge(dest, weight));
		L.get(dest).add(new Edge(src, weight));
	}
}

public class Dijkstra {
	public static void dijkstra(Graph g, int s) {
		int[] d = new int[g.V];
		int[] p = new int[g.V];

		for (int i = 0; i < g.V; i++) {
			d[i] = Integer.MAX_VALUE;
			p[i] = Integer.MAX_VALUE;
		}

		d[s] = 0;
		p[s] = -1;

		PriorityQueue<Node> Q = new PriorityQueue<Node>();
		Q.add(new Node(s, 0));

		while (!Q.isEmpty()) {
			int w = Q.poll().value;

			for (int i = 0; i < g.L.get(w).size(); i++) {
				if (p[g.L.get(w).get(i).dest] == Integer.MAX_VALUE) {
					d[g.L.get(w).get(i).dest] = d[w] + g.L.get(w).get(i).weight;
					p[g.L.get(w).get(i).dest] = w;
					Q.add(new Node(i, d[g.L.get(w).get(i).dest]));
				} else if (d[w] + g.L.get(w).get(i).weight < d[g.L.get(w).get(i).dest]) {
					int o = d[g.L.get(w).get(i).dest];
					d[g.L.get(w).get(i).dest] = d[w] + g.L.get(w).get(i).weight;
					p[g.L.get(w).get(i).dest] = w;
					Q.remove(new Node(i, o));
					Q.add(new Node(i, d[g.L.get(w).get(i).dest]));
				}
			}
		}
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.toString(p));
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.edge(0, 1, 1);
		g.edge(0, 2, 3);
		g.edge(0, 3, 5);
		g.edge(1, 2, 2);
		g.edge(1, 3, 3);
		g.edge(2, 3, 4);
		dijkstra(g, 0);
	}
}
