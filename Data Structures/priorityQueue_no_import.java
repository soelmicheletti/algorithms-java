// AUTHOR: Soel Micheletti
class PriorityQueue{
	int size; 
	Nodo[] a = new Nodo[10000]; 
	
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
			Nodo tmp = a[i]; 
			a[i] = a[index]; 
			a[index] = tmp; 
			heapify(index); 
		}
	}
	
	public void decreaseKey(int i, int key) {
		if(key<a[i].p) {
			a[i].p = key; 
			while(i>0 && a[i/2].p>a[i].p) {
				Nodo tmp = a[i/2]; 
				a[i/2] = a[i]; 
				a[i] = tmp;
				i /= 2; 
			}

		}
	}
	
	public void insert(int v, int p) {
		a[size] = new Nodo(v, Integer.MAX_VALUE); 
		size++; 
		decreaseKey(size-1, p); 
	}
	
	public int extractMin() {
x		int min = a[0].value; 
		a[0] = a[size-1]; 
		size--; 
		heapify(0); 
		return min; 
	}
	
}
