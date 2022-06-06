// AUTHOR: Soel Micheletti

import java.util.Random; 

class BubbleSort{

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                int tmp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
    
    public static boolean isSorted(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] > array[i + 1])
                return false; 
        }
        return true; 
    }

    public static void main(String[] args) {
        
        Random ran = new Random(); 

        int[] array = new int[10000]; 

        for(int i = 0; i < array.length; i++){
            array[i] = ran.nextInt(10000); 
        }

        bubbleSort(array); 

        System.out.println(isSorted(array));
    }
}
