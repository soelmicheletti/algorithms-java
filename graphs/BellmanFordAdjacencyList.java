// AUTHOR: Soel Micheletti
import java.util.ArrayList;
import java.util.Arrays;

class Edge {
	int dest;
	int weight;

	public Edge(int dest, int weight) {
		this.dest = dest;
		this.weight = weight;
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
	}
}

public class BellmanFord {
	public static void bellmanFord(Graph g, int s) {
		int[] d = new int[g.V];
		int[] p = new int[g.V];

		for (int i = 0; i < g.V; i++)
			d[i] = p[i] = 1030;

		d[s] = 0;
		p[s] = -1;

		for (int i = 0; i < g.V - 1; i++) {
			relax(g, d, p);
		}

		for (int i = 0; i < g.L.size(); i++) {
			for (int j = 0; j < g.L.get(i).size(); j++) {
				if (d[i] + g.L.get(i).get(j).weight < d[g.L.get(i).get(j).dest]) {
					System.out.println("Negative cycle");
				}
			}
		}
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.toString(p));
	}

	public static void relax(Graph g, int[] d, int[] p) {
		for (int i = 0; i < g.L.size(); i++) {
			for (int j = 0; j < g.L.get(i).size(); j++) {
				if (d[i] + g.L.get(i).get(j).weight < d[g.L.get(i).get(j).dest]) {
					d[g.L.get(i).get(j).dest] = d[i] + g.L.get(i).get(j).weight;
					p[g.L.get(i).get(j).dest] = i;
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.edge(0, 1, 10);
		g.edge(0, 5, 8);
		g.edge(1, 3, 2);
		g.edge(2, 1, 1);
		g.edge(3, 2, -2);
		g.edge(4, 1, -4);
		g.edge(4, 3, -1);
		g.edge(5, 4, 1);

		bellmanFord(g, 0);
	}

}
