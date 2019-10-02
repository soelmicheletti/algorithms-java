class Node{
	Node next; 
	Node prev; 
	int value; 
	
	public Node(int v) {
		value = v; 
	}
}
public class Queue {
	Node first; 
	Node last; 
	int size; 
	
	public boolean isEmpty() {
		return size == 0; 
	}
	
	public void enqueue(int x) {
		Node n = new Node(x); 
		
		if(isEmpty()) {
			first = last = n; 
			size = 1; 
		}
		else {
			last.next = n; 
			n.prev = last; 
			last = n; 
			size++; 
		}
	}
	
	public Node front() {
		if(isEmpty())
			throw new RuntimeException("Empty Stack"); 
		else {
			Node n = first; 
			return n; 
		}
	}
	
	public Node dequeue() {
		if(isEmpty())
			throw new RuntimeException("Empty Stack"); 
		else if(size == 1) {
			Node n = first; 
			first = last = null; 
			size = 0; 
			return n; 
		}
		else {
			Node n = first; 
			first.next.prev = null; 
			first = first.next; 
			size--; 
			return n; 
		}
	}
}
