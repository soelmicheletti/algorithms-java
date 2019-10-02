import java.util.Random; 

class SelectionSort{

    public static int[] selectionSort(int[] a) {
		for(int i = a.length - 1; i>= 0; i--) {
			int max = a[0]; 
			int index = 0; 
			for(int j = 0; j<= i; j++) {
				if(a[j]>max) {
					max = a[j];
					index = j; 
				}
			}
			int tmp = a[i]; 
			a[i] = max; 
			a[index] = tmp; 
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
        selectionSort(a); 
        System.out.println(isSorted(a));
    }
}
