import java.util.PriorityQueue;

 class Node implements Comparable<Node>{
	int value; 
	int p; 
	
	public Node(int value, int p) {
		this.value = value; 
		this.p = p; 
	}
	

	public int compareTo(Node a) {
		if(a.p == p)
			return 0;
		else if(p>a.p)
			return 1; 
		return -1; 
	}

}

public class PriorityQueue{
	public static void main(String[]args) {
		PriorityQueue<Node> P = new PriorityQueue<Node>();
		P.add(new Node(100, 1)); 
		P.add(new Node(1, 100)); 
		System.out.println(P.remove().value); 
	}
}
