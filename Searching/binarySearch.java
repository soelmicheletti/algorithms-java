// AUTHOR: Soel Micheletti

public static int binarySearch(int[] a, int value) {
    int left = 0; 
    int right = a.length; 
    
    while(left<=right) {
        int middle = (left+right)/2; 
        if(a[middle]==value) {
            return middle; 
        }
        else if(a[middle]<value) {
            left = middle+1; 
        }
        else {
            right = middle-1; 
        }
    }
    return -1; 
}
