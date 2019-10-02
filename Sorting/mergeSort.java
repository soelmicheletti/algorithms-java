import java.util.Random; 

class a{

    public static int[] mergeSort(int[] a) {
		return mergeSort(a, new int[a.length], 0, a.length - 1); 
	}
	
	public static int[] mergeSort(int[] a, int[] tmp, int left, int right) {
		if(left < right) {
			int mid = (left+right)/2; 
			mergeSort(a, tmp, left, mid); 
			mergeSort(a, tmp, mid+1, right); 
			merge(a, tmp, left, mid, mid+1, right); 
		}
		return a; 
	}
	
	public static int[] merge(int[] a, int[] tmp, int leftStart, int leftEnd, int rightStart, int rightEnd) {
		int size = rightEnd - leftStart + 1; 
		int index = leftStart; 
		
		while(leftStart <= leftEnd && rightStart <= rightEnd) {
			if(a[leftStart]<= a[rightStart])
				tmp[index++] = a[leftStart++]; 
			else
				tmp[index++] = a[rightStart++]; 
		}
		
		while(leftStart<=leftEnd)
			tmp[index++] = a[leftStart++];
		while(rightStart<=rightEnd)
			tmp[index++] = a[rightStart++];
		for(int i = 0; i<size; i++) {
			a[rightEnd] = tmp[rightEnd]; 
			rightEnd--; 
		}
		return a; 
	}
    
    public static boolean isSorted(int[] a){
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] > a[i + 1])
                return false; 
        }
        return true; 
    }
    public static void main(String[] args) {
        Random ran = new Random(); 

        int[] a = new int[10000]; 
        for(int i = 0; i < a.length; i++){
            a[i] = ran.nextInt(10000); 
        }
        mergeSort(a); 
        System.out.println(isSorted(a));
    }
}
