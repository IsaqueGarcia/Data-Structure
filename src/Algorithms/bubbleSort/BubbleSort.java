package Algorithms.bubbleSort;

import java.util.Arrays;

public class BubbleSort {


    public static void sort(int[] array){
        for(int i = array.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arrayInt = {2,6,4,3,1,5};
        sort(arrayInt);
        System.out.println(Arrays.toString(arrayInt));
    }

}
