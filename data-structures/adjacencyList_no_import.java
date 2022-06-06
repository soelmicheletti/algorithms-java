// AUTHOR: Soel Micheletti

class Node{
	int dest; 
	int weight; 
	Node next; 
	
	public Node(int a, int b) {
		dest = a; 
		weight = b; 
	}
}

class List{
	int size; 
	Node first; 
	Node last;
	
	public List() {
		first = last = new Node(33, 33); 
		size = 1; 
	}
	
	public void add(int dest, int weight) {
		Node o = new Node(dest, weight);
		if(size == 0) {
			first = last = o;
			size++; 
		}
		else {
			last.next = o; 
			last = o; 
			size++; 
		}
	}
}


class Graph{
	int V; 
	List[] T;  
	
	public Graph(int v) {
		V = v; 
		T = new List[V]; 
		for(int i = 0; i<V; i++) {
			T[i] = new List(); 
		}
	}
	
	public void edge(int src, int dest, int p) {
		T[src].add(dest, p);
		T[dest].add(src, p);
	}
}
