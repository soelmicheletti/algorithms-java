class Node<T>{
	T item; 
	Node parent;
	
	public Node(T item) {
		this.item = item; 
	}
}
public class UnionFind<T> {

	public void makeSet(Node n) { 
		n.parent = n; 
	}
	
	public Node find(Node a) {
		if(a.parent.equals(a))
			return a; 
		else {
			Node tmp = find(a.parent);
			a.parent = tmp;
			return tmp; 
		}
	}
	
	public void union(Node a, Node b) {
		Node t1 = find(a); 
		Node t2 = find(b); 
		
		a.parent = b; 
	}
	
	public static void main(String[]args) {
		UnionFind<Integer> U = new UnionFind<Integer>(); 
		Node a = new Node("a"); 
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		Node k = new Node("k");
		
		
		U.makeSet(a);
		U.makeSet(b);
		U.makeSet(c);
		U.makeSet(d);
		U.makeSet(e);
		U.makeSet(f);
		U.makeSet(g);
		U.makeSet(k);
		
	
		b.parent = a;  
		c.parent = a;
		g.parent = b; 
		k.parent = g; 
		d.parent = b; 
		e.parent = d; 
		f.parent = d; 
		
		U.find(e); 
		System.out.println(a.parent.item); 
		System.out.println(e.parent.item); 
		
		System .out.println(d.parent.item); 

		
		System.out.println(f.parent.item); 

		
		System.out.println(b.parent.item); 

		
		System.out.println(g.parent.item); 

		
		System.out.println(k.parent.item); 

		
		System.out.println(c.parent.item); 




	}
}


