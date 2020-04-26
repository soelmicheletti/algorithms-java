// AUTHOR: Soel Micheletti
// Code used for a submission in an AW programming exercise
import java.util.Scanner;


class Edge{
	int dest; 
	int weight; 
	Edge next; 
	
	public Oggetto(int a, int b) {
		dest = a; 
		weight = b; 
	}
}

class List{
	int size; 
	Edge first; 
	Edge last;
	
	public List() {
		first = last = new Edge(33, 33); 
		size = 1; 
	}
	
	public void add(int dest, int peso) {
		Edge o = new Edge(dest, peso);
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


class Node{
	int value; 
	int p; 
	
	public Node(int a, int b) {
		value = a; 
		p = b; 
	}
}

class PriorityQueue{
	int size; 
	Node[] a = new Node[10000]; 
	
	public PriorityQueue() {
		size = 0; 
	}
	
	public void heapify(int i) {
		int m = a[i].p;
		int index = i; 
		if(2*i<=size && a[2*i].p<m) {
			m = a[2*i].p; 
			index = 2*i; 
		}
		if(2*i+1<=size && a[2*i+1].p<m) {
			m = a[2*i+1].p; 
			index = 2*i+1; 
		}
		
		if(m != a[i].p) {
			Node tmp = a[i]; 
			a[i] = a[index]; 
			a[index] = tmp; 
			heapify(index); 
		}
	}
	
	public void decreaseKey(int i, int key) {
		if(key<a[i].p) {
			a[i].p = key; 
			while(i>0 && a[i/2].p>a[i].p) {
				Node tmp = a[i/2]; 
				a[i/2] = a[i]; 
				a[i] = tmp;
				i /= 2; 
			}

		}
	}
	
	public void insert(int v, int p) {
		a[size] = new Node(v, Integer.MAX_VALUE); 
		size++; 
		decreaseKey(size-1, p); 
	}
	
	public int extractMin() {
		int min = a[0].value; 
		a[0] = a[size-1]; 
		size--; 
		heapify(0); 
		return min; 
	}
	
}


class Prim {
	
	
	public static void prim(Graph g) {
		int[] d = new int[g.V]; 
		int[] p = new int[g.V]; 
		boolean[] in = new boolean[g.V]; 
		
		for(int i = 0; i<g.V; i++) {
			d[i] = Integer.MAX_VALUE; 
			p[i] = -1; 
		}
		
		d[0] = 0; 
		p[0] = -3; 
		
		PriorityQueue Q = new PriorityQueue(); 
		Q.insert(0, 0);
		
		while(Q.size != 0) {
			int u = Q.extractMin(); 
			in[u] = true; 
			
			Edge v = g.T[u].first.next; 
			while(v != null) {
				
				if(!in[v.dest] && d[v.dest]>v.peso) {
					d[v.dest] = v.peso; 
					Q.insert(v.dest, d[v.dest]);
				}
				
				v = v.next; 
			}
		}
		int r = 0; 
		for(int i = 0; i<g.V; i++) {
			r +=d[i]; 
		}
		System.out.println(r); 
		
	}
	
	
	
    public static void main(String[] args) {
        // Create a new Scanner object for reading the input
        Scanner sc = new Scanner(System.in);

        // Read the number of testcases to follow
        int t = sc.nextInt();

        // Iterate over the testcases and solve the problem
        for (int i = 0; i < t; i++) {
            testCase(sc);
        }
    }

    public static void testCase(Scanner sc) {
        
    	Graph g = new Graph(sc.nextInt()); 
    	int m = sc.nextInt(); 
    	//System.out.println(m);
    	for(int i = 0; i<m; i++) {
    		g.edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
    	}
    	
    	prim(g); 
        
    }
}
