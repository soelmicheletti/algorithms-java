// AUTHOR: Soel Micheletti

// Does not require the array to be sorted
public static int linearSearch(int[] a, int n) {
        for(int i = 0; i<a.length;  i++) {
            if(a[i]==n) {
                return i; 
            }
        }
        return -1; 
}
