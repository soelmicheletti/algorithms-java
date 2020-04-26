// AUTHOR: Soel Micheletti
import java.util.Arrays;

class Node{
	int v;
	int p; 
	
	public Node(int v, int p) {
		this.v = v; 
		this.p = p; 
	}
}

class PriorityQueue{
	Node[] a = new Node[10000]; 
	int size; 
	
	public void heapify(int i) {
		int m = a[i].p; 
		int index = i; 
		
		if(2*i<size && a[2*i].p<m) {
			m = a[2*i].p; 
			index = 2*i; 
		}
		if(2*i+1<size && a[2*i+1].p<m) {
			m = a[2*i+1].p; 
			index = 2*i+1; 
		}
		if(index != i) {
			Node tmp = a[i]; 
			a[i] = a[index]; 
			a[index] = tmp; 
			heapify(index); 
		}
	}
	
	public void decreaseKey(int i, int p) {
		if(a[i].p >= p) {
			a[i].p = p; 
			while(i>= 0 && a[i].p<a[i/2].p) {
				Node tmp = a[i]; 
				a[i] = a[i/2]; 
				a[i/2] = tmp; 
				i /= 2; 
			}
		}
	}
	
	public int extractMin() {
		int u = a[0].v; 
		a[0] = a[size-1]; 
		size--; 
		heapify(0); 
		return u; 
	}
	
	public void insert(int v, int p) {
		Node n = new Node(v, Integer.MAX_VALUE); 
		a[size] = n; 
		size++; 
		decreaseKey(size - 1, p); 
	}
}

class Edge{
	int dest; 
	int weight; 
	Edge next; 
	
	public Edge(int dest, int weight) {
		this.dest = dest; 
		this.weight = weight; 
	}
}

class List{
	Edge first; 
	Edge last; 
	int size; 
	
	public void add(int dest, int weight) {
		Edge n = new Edge(dest, weight); 
		if(size == 0) {
			first = last = n; 
			size++; 
		}
		else {
			last.next = n; 
			last = n; 
			size++; 
		}
	}
}

class Graph{
	List[] L; 
	int V; 
	
	public Graph(int v) {
		V = v;
		L = new List[v]; 
		for(int i = 0; i<v; i++) {
			L[i] = new List(); 
		}
	}
	
	public void edge(int src, int dest, int weight) {
		L[src].add(dest, weight);
		L[dest].add(src, weight);
	}
}

public class Dijkstra{
	public static void dijkstra(Graph g, int s) {
		int[] d = new int[g.V]; 
		int[] p = new int[g.V]; 
		
		for(int i = 0; i<g.V; i++) {
			d[i] = Integer.MAX_VALUE; 
			p[i] = -1; 
		}
		
		d[s] = 0; 
		p[s] = -3; 
		
		PriorityQueue Q = new PriorityQueue(); 
		Q.insert(s, 0);
		
		while(Q.size != 0) {
			int w = Q.extractMin(); 
			Edge n = g.L[w].first; 
			
			while(n != null) {
				if(p[n.dest] == -1) {
					p[n.dest] = w; 
					d[n.dest] = d[w] + n.weight; 
					Q.insert(n.dest, d[n.dest]);
				}
				else if(d[w] + n.weight <d[n.dest]) {
					p[n.dest] = w; 
					d[n.dest] = d[w] + n.weight; 
					if(Q.a[n.dest] != null)
					Q.decreaseKey(n.dest, d[n.dest]);
				}
				n = n.next; 
			}
		}
		System.out.println(Arrays.toString(d)); 
		System.out.println(Arrays.toString(p)); 
	}
	
	public static void main(String[]args) {
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
