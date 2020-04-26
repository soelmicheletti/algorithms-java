// AUTHOR: Soel Micheletti

// Binary Search + heuristic to improve the performance
// Requires array to be sorted
public static int interpolationSearch(int[] a, int b) {
		int left = 0; 
		int right = a.length-1; 
		
		while(left<=right) {
			int p = (b-a[left])/(a[right]-a[left]); 
			int pivot = left+p*(right-left); 
			if(a[pivot] == b)
				return pivot; 
			else if(a[pivot]>b)
				right = pivot-1; 
			else
				left = pivot+1; 
		}
		return -1; 
	}
