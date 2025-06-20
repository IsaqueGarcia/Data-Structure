package Algorithms.insertionSort;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] array){
        for(int i = 1; i < array.length; i ++){
            int temp = array[i];
            int j = i - 1;
            while(j > -1 && temp < array[j]){
                array[j + 1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arrayInt = {2,6,4,3,1,5};
        sort(arrayInt);
        System.out.println(Arrays.toString(arrayInt));
    }

}
