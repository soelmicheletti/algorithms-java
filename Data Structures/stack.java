class Node {
	Node next;
	Node prev;
	int value;

	public Node(int x) {
		value = x;
	}
}

class Stack {
	Node first;
	Node last;
	int size;

	public Stack() {
		first = null;
		last = null;
		size = 0;
	}

	public void push(int x) {
		Node n = new Node(x);
		if (isEmpty()) {
			first = last = n;
			size++;
		} else {
			n.prev = last;
			last.next = n;
			last = n;
			size++;
		}
	}

	public Node pop() {
		if (isEmpty()) {
			throw new RuntimeException("Empty Stack!");
		} 
		else if (size == 1) {
			Node x = last; 
			first = last = null; 
			size = 0; 
			return x; 
		}
		else {
			Node x = last;
			last.prev.next = null; 
			last = last.prev;
			size--;
			return x;
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Node top() {
		if (isEmpty()) {
			throw new RuntimeException("Empty Stack!");
		} else {
			return last;
		}
	}

}

