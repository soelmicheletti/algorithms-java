class Node {
	Node left;
	Node right;
	Node parent;
	int value;

	public Node(int v) {
		value = v;
	}
}

class BinaryTree {
	Node root;

	public BinaryTree() {

	}

	public void add(int x) {
		if (root == null)
			root = new Node(x);
		else {
			Node current = root;
			while (current != null) {
				if (x <= current.value && current.left != null)
					current = current.left;
				else if (x <= current.value) {
					Node n = new Node(x);
					n.parent = current;
					current.left = n;
					current = null;
				} else if (x > current.value && current.right != null)
					current = current.right;
				else {
					Node n = new Node(x);
					n.parent = current;
					current.right = n;
					current = null;
				}
			}
		}
	}

	public Node search(Node n) {
		if (root == null)
			return null;
		else {
			Node current = root;
			while (current != n && current != null) {
				if (n.value == current.value)
					return current;
				else if (n.value < current.value)
					current = current.left;
				else
					current = current.right;
			}
			return null;
		}
	}

	public void delete(int x) {
		if (root == null || search(new Node(x)) == null)
			System.out.println("Not found");
		else if (root.value == x) {
			if (root.left == null)
				root = root.right;
			else if (root.right == null)
				root = root.left;
			else {
				if (root.left.right == null) {
					root.left.right = root.right;
					root = root.left;
				} else {
					Node t = root.left.right;
					while (t != null)
						t = t.right;
					t.parent.right = null;
					t.parent = null;
					t.left = root.left;
					t.right = root.right;
				}
			}
		} else {
			Node c = search(new Node(x));
			if (c.parent.left.equals(c)) {
				if (c.left == null && c.right == null)
					c.parent.left = null;
				else if (c.left == null) {
					c.parent.left = c.right;
					c.right.parent = c.parent;
				} else if (c.right == null) {
					c.parent.left = c.left;
					c.left.parent = c.parent;
				} else {
					Node t = c.left;
					while (t.right != null)
						t = t.right;
					if (t.equals(c.left)) {
						t.parent = c.parent;
						c.parent.left = t;
					} else {
						t.parent.right = null;
						t.parent = c.parent;
						c.parent.left = t;
						t.left = c.left;
						t.right = c.right;
					}

				}
			} else {
				if (c.left == null && c.right == null)
					c.parent.right = null;
				else if (c.left == null) {
					c.parent.right = c.right;
					c.right.parent = c.parent;
				} else if (c.right == null) {
					c.parent.right = c.left;
					c.left.parent = c.parent;
				} else {
					Node t = c.left;
					while (t.right != null)
						t = t.right;
					if (t.equals(c.left)) {
						t.parent = c.parent;
						c.parent.right = t;
					} else {
						t.parent.right = null;
						t.parent = c.parent;
						c.parent.right = t;
						t.left = c.left;
						t.right = c.right;
					}

				}
			}
		}
	}

	public void print(Node n) {
		if (n == null) {
		} else {
			System.out.println(n.value);
			print(n.left);
			print(n.right);
		}
	}
}
