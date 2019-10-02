import java.util.Random; 
// This implementation of QuickSort works only on arrays where elements are pairwise different
class QuickSort{

    public static int[] quickSort(int[] a){
        return quickSort(a, 0, a.length - 1); 
    }

    public static int[] quickSort(int[] a, int left, int right){
        if(left < right){
            int k = partition(a, left, right); 
            quickSort(a, left, k - 1); 
            quickSort(a, k + 1, right); 
        }
        return a; 
    }

    public static int partition(int[] a, int left, int right){
        int l = left; 
        int r = right-1;
        int p = a[right];  

        while(l<r){
            while(a[l]<p)
                l++; 
            while(a[r]>p)
                r--; 
            if(l<r){
                int tmp = a[l]; 
                a[l] = a[r]; 
                a[r] = tmp;
            }
        }
        int tmp = a[l]; 
        a[l] = p; 
        a[right] = tmp; 
        return l; 
    }
    
    public static boolean isSorted(int[] a){
        for(int i = 0; i < a.length - 1; i++){
            if(a[i] > a[i + 1])
                return false; 
        }
        return true; 
    }
    public static void main(String[] args) {
 
        int[] a = {3, 4, 1, 5, 2, 9, 6}; 
        quickSort(a); 
        System.out.println(isSorted(a));
    }
}
