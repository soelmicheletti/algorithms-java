// AUTHOR: Soel Micheletti

// Requires array to be sorted. Uses binarySearch as subroutine, but can improve runtime in some cases
public static int exponentialSearch(int[] a, int b) {
        int r = 1; 
        while(r<=a.length && a[r]<b){
            r *= 2; 
        }

        int min = Math.min(r, a.length); 
        int [] bUP = new int[min]; 
        for(int i = 0; i<bUP.length; i++) {
            bUP[i] = a[i]; 
        }
 
        return binarySearch(bUP, b);	
}
