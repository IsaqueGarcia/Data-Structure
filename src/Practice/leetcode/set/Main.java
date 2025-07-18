package Practice.leetcode.set;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
        List<Integer> newList = removeDuplicates(myList);
        System.out.println(newList);

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 2, 3, 4, 5, 6, 7, 8, 9]

            (Order may be different as sets are unordered)
        */
    }

    public static List<Integer> removeDuplicates(List<Integer> myList){
        Set<Integer> uniqueElements = new HashSet<>(myList);
        return new ArrayList<>(uniqueElements);
    }

    public static boolean hasUniqueChars(String word){
        Set<Character> uniqueChars = new HashSet<>();
        char[] arrayWords = word.toCharArray();
        for (char arrayWord : arrayWords) {
            uniqueChars.add(arrayWord);
        }

        return arrayWords.length == uniqueChars.size();
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2,int target){
        Set<Integer> pairsToCompare = new HashSet<>();
        List<int[]> savedPairs = new ArrayList<>();

        for(int num : arr1){
            pairsToCompare.add(num);
        }

        for(Integer num : arr2){
            if(pairsToCompare.contains(target - num)){
                int checkedNum = target - num;
                savedPairs.add(new int[]{ checkedNum, num});
            }
        }
        return savedPairs;
    }

    public static int longestConsecutiveSequence(int[] array1){
        Set<Integer> mySet = new HashSet<>();
        int longestSequence = 0;

        for(int num : array1){
            mySet.add(num);
        }

        for(Integer num : mySet){
            int sequence = 1;
            int nextNum = num + 1;
            while(mySet.contains(nextNum)){
                sequence++;
                nextNum++;
            }
            longestSequence = sequence > longestSequence ? sequence : longestSequence;
        }

        return longestSequence;
    }

}
