package Algorithms.selectionSort;

import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] array){
       for(int i = 0; i < array.length; i++){
           int minIndex = i;
           for(int j = i + 1; j < array.length; j++){
               if(array[j] < array[minIndex]){
                   minIndex = j;
               }
           }
           if(minIndex != i){
               int temp = array[i];
               array[i] = array[minIndex];
               array[minIndex] = temp;
           }
       }
    }

    public static void main(String[] args) {
        int[] arrayInt = {2,6,4,3,1,5};
        sort(arrayInt);
        System.out.println(Arrays.toString(arrayInt));
    }

}
