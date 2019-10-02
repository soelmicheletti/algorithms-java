class Oggetto{
	int dest; 
	int peso; 
	Oggetto next; 
	
	public Oggetto(int a, int b) {
		dest = a; 
		peso = b; 
	}
}

class Lista{
	int size; 
	Oggetto first; 
	Oggetto last;
	
	public Lista() {
		first = last = new Oggetto(33, 33); 
		size = 1; 
	}
	
	public void add(int dest, int peso) {
		Oggetto o = new Oggetto(dest, peso);
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
	Lista[] T;  
	
	public Graph(int v) {
		V = v; 
		T = new Lista[V]; 
		for(int i = 0; i<V; i++) {
			T[i] = new Lista(); 
		}
	}
	
	public void edge(int src, int dest, int p) {
		T[src].add(dest, p);
		T[dest].add(src, p);
	}
}

