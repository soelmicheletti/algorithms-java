// AUTHOR: Soel Micheletti
import java.util.Random; 

class InsertionSort{

    public static int[] insertionSort(int[] a) {
		for(int i = 1; i<a.length; i++) {
			int j = i; 
			while(j > 0 && a[j] < a[j-1]) {
				int tmp = a[j]; 
				a[j] = a[j-1]; 
				a[j-1] = tmp; 
				j--; 
			}
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
        insertionSort(a); 
        System.out.println(isSorted(a));
    }
}
