// AUTHOR: Soel Micheletti
import java.util.ArrayList;
import java.util.Stack;

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
		for (int i = 0; i < V; i++) {
			L.add(new ArrayList<Edge>());
		}
	}

	public void edge(int src, int dest, int weight) {
		L.get(src).add(new Edge(dest, weight));
	}
}

public class Topo {
	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + "\t");
	}

	public static void Topo(Graph g) {
		int[] ord = new int[g.V];
		int[] in = new int[g.V];

		for (int i = 0; i < g.V; i++) {
			for (int j = 0; j < g.L.get(i).size(); j++)
				in[g.L.get(i).get(j).dest]++;
		}
		Stack S = new Stack();
		for (int i = 0; i < g.V; i++) {
			if (in[i] == 0)
				S.add(i);
		}
		int i = 1;
		while (!S.isEmpty()) {
			int w = (int) S.pop();
			ord[w] = i;
			i++;
			for (int j = 0; j < g.L.get(w).size(); j++) {
				in[g.L.get(w).get(j).dest]--;
				if (in[g.L.get(w).get(j).dest] == 0)
					S.add(g.L.get(w).get(j).dest);
			}
		}
		if (i == g.V + 1) {
			print(ord);
		} else {
			System.out.println("Cycle");
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.edge(0, 1, 1);
		g.edge(0, 2, 1);
		g.edge(1, 3, 1);
		g.edge(2, 3, 1);
		g.edge(3, 4, 1);
		g.edge(3, 5, 1);
		g.edge(5, 4, 1);
		Topo(g);
	}
}
