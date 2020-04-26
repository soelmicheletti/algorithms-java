// AUTHOR: Soel Micheletti
import java.util.Random; 

class a{

    public static int[] quickSort(int[] a){
        return quickSort(a, 0, a.length - 1); 
    }

    public static int[] quickSort(int[] a, int left, int right){
        int l = left; 
        int r = right; 
        int p = a[(left + right) / 2]; 

        while(l <= r){
            while(a[l]<p)
                l++; 
            while(a[r]>p)
                r--; 
            if(l <= r){
                int tmp = a[l]; 
                a[l] = a[r]; 
                a[r] = tmp; 
                l++;
                r--;
            }
        }
        if(left < r)
            quickSort(a, left, r);
        if(l < right)
            quickSort(a, l, right);
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
        quickSort(a); 
        System.out.println(isSorted(a));
    }
}
