package Algorithms.mergeSort;

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] array1, int[] array2){
        int[] combined = new int[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;

        while(i < array1.length && j < array2.length){
            if(array1[i] < array2[j]){
                combined[index] = array1[i];
                index++;
                i++;
            }else{
                combined[index] = array2[j];
                index++;
                j++;
            }
        }

        while(i < array1.length){
            combined[index] = array1[i];
            index++;
            i++;
        }

        while (j < array2.length){
            combined[index] = array2[j];
            index++;
            j++;
        }

        return combined;
    }

    public static int[] mergeSort(int[] array){

        if(array.length == 1) return array; //base case for break the call

        int midIndex = array.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }

    public static void main(String[] args) {
        int[] array = {3,1,4,2};
        int[] ordenedArray = mergeSort(array);

        System.out.println("Before: " + Arrays.toString(array));
        System.out.println("After order:" + Arrays.toString(ordenedArray));
    }

}
