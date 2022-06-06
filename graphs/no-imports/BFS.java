// AUTHOR: Soel Micheletti

class Node {
	int dest;
	int weight;
	Node next;

	public Node(int d, int w) {
		dest = d;
		weight = w;
	}
}

class List {
	Node first;
	Node last;
	int size;

	public List() {

	}

	public void add(int dest, int weight) {
		Node n = new Node(dest, weight);
		if (size == 0) {
			first = last = n;
			size = 1;
		} else {
			last.next = n;
			size++;
		}
	}
}

class Graph {
	List[] L;
	int v;

	public Graph(int v) {
		L = new List[v];
		for (int i = 0; i < v; i++)
			L[i] = new List();
		this.v = v;
	}

	public void edge(int src, int dest, int weight) {
		L[src].add(dest, weight);
	}
}

class Node_queue {
	Node_queue next;
	Node_queue prev;
	int value;

	public Node_queue(int v) {
		this.value = v;
	}
}

class Queue {
	Node_queue first;
	Node_queue last;
	int size;

	public Queue() {

	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void enqueue(int x) {
		Node_queue n = new Node_queue(x);
		if (isEmpty()) {
			first = last = n;
			size = 1;
		} else {
			last.next = n;
			n.prev = last;
			last = n;
			size++;
		}
	}

	public Node_queue dequeue() {
		if (isEmpty())
			throw new RuntimeException("Empty Queue");
		else if (size == 1) {
			Node_queue n = first;
			first = last = null;
			size = 0;
			return n;
		} else {
			Node_queue n = first;
			first.next.prev = null;
			first = first.next;
			size--;
			return n;
		}
	}
}

class BFS {
	Graph g;
	boolean[] activ;
	boolean[] visited;

	public BFS(Graph g) {
		this.g = g;
		activ = new boolean[g.v];
		visited = new boolean[g.v];
	}

	public void BFS() {
		Queue Q = new Queue();
		Q.enqueue(0);
		activ[0] = true;

		while (!Q.isEmpty()) {
			Node_queue w = Q.dequeue();
			System.out.println(w.value);
			visited[w.value] = true;
			Node n = g.L[w.value].first;
			while (n != null) {
				if (!activ[n.dest] && !visited[n.dest]){
					Q.enqueue(n.dest);
					activ[n.dest] = true; 
				}
				n = n.next;
			}
		}
	}
}
