// AUTHOR: Soel Micheletti

class Node {
	Node next;
	Node prev;
	int value;

	public Node(int v) {
		value = v;
	}
}

class Stack {
	Node first;
	Node last;
	int size;

	public Stack() {
		first = last = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void push(int a) {
		Node n = new Node(a);
		if (isEmpty()) {
			first = last = n;
			size = 1;
		} else {
			n.prev = last;
			last.next = n;
			last = n;
			size++;
		}
	}

	public Node pop() {
		if (isEmpty()) {
			throw new RuntimeException("Empty Stack");
		} else if (size == 1) {
			Node n = last;
			first = last = null;
			size = 0;
			return n;
		} else {
			Node n = last;
			last.prev.next = null;
			last = last.prev;
			size--;
			return n;
		}
	}
}

class Edge {
	int dest;
	int weight;
	Edge next;

	public Edge(int dest, int weight) {
		this.dest = dest;
		this.weight = weight;
	}
}

class List {
	Edge first;
	Edge last;
	int size;

	public List() {
		first = last = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(int dest, int weight) {
		Edge n = new Edge(dest, weight);
		if (isEmpty()) {
			first = last = n;
			size = 1;
		} else {
			last.next = n;
			last = n;
			size++;
		}
	}
}

class Graph {
	int V;
	List[] L;

	public Graph(int v) {
		this.V = v;
		L = new List[v]; 
		for (int i = 0; i < v; i++)
			L[i] = new List();
	}

	public void edge(int source, int dest, int weight) {
		L[source].add(dest, weight);
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
		Stack S = new Stack();
		S.push(0);

		while (!S.isEmpty()) {
			int w = S.pop().value;
			if (!visited[w]) {
				System.out.println(w);
				visited[w] = true;
				Edge n = g.L[w].first;
				while (n != null) {
					if (!visited[n.dest])
						S.push(n.dest);
					n = n.next;
				}
			}
		}
	}
}
