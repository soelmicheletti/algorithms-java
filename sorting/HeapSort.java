// AUTHOR: Soel Micheletti

import java.util.Random; 

class HeapSort{

    public static int[] restoreHeap(int[] a, int i, int m) {
        while(2 * i <= m) {
            int j = 2 * i; 
            if(j + 1 <= m && a[j + 1] > a[j])
                j++; 
            if(a[j] > a[i]) {
                int tmp = a[i]; 
                a[i] = a[j]; 
                a[j] = tmp; 
                i = j; 
            } else {
                break; 
            }
        }
        return a; 
    }
    
    public static int[] heapSort(int[] a){
        for(int i = a.length / 2; i>= 0; i--) {
            restoreHeap(a, i, a.length - 1);
        }
        for(int i = a.length - 1; i >= 1; i--) {
            int tmp = a[0]; 
            a[0] = a[i]; 
            a[i] = tmp; 
            restoreHeap(a, 0, i-1); 
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
        heapSort(a); 
        System.out.println(isSorted(a));
    }
}
