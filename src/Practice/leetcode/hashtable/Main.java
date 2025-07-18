package Practice.leetcode.hashtable;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        int[] result1 = subarraySum(nums1, target1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {-1, 2, 3, -4, 5};
        int target2 = 0;
        int[] result2 = subarraySum(nums2, target2);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {2, 3, 4, 5, 6};
        int target3 = 3;
        int[] result3 = subarraySum(nums3, target3);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");

        int[] nums4 = {};
        int target4 = 0;
        int[] result4 = subarraySum(nums4, target4);
        System.out.println("[]");

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 3]
            [0, 3]
            [1, 1]
            []

        */
    }

    public static boolean itemInCommon(int[] array1, int[] array2) {

        HashMap<Integer, Boolean> aggregateValues = new HashMap<>();

        for (int value : array1) {
            aggregateValues.put(value, true);
        }

        for (int value : array2) {
            aggregateValues.put(value, true);
        }

        return aggregateValues.size() != (array1.length + array2.length);
    }

    public static ArrayList<Integer> findDuplicates(int[] array) {
        HashMap<Integer, Boolean> duplicates = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int number : array) {
            if (duplicates.containsKey(number)) {
                if (!result.contains(number)) {
                    result.add(number);
                }
            } else {
                duplicates.put(number, true);
            }
        }

        return result;
    }

    public static Character firstNonRepeatingChar(String word) {
        char[] chars = word.toCharArray();
        Map<Character, Integer> storedValues = new HashMap<>();

        for(char x : chars){
            storedValues.put(x, storedValues.getOrDefault(x, 0) + 1);
        }

        for(char y : chars){
            if(storedValues.get(y) == 1){
                return y;
            }
        }
        return null;
    }

    public static List<List<String>> groupAnagrams(String[] strings){

        HashMap<String, ArrayList<String>> agroupsWords = new HashMap<>();

        for(String string : strings){
           char[] charsAfterSort = string.toCharArray();
           Arrays.sort(charsAfterSort);

           String word = Arrays.toString(charsAfterSort);
           if(agroupsWords.containsKey(word)){
               agroupsWords.get(word).add(string);
           }else{
               ArrayList<String> listForAddWord = new ArrayList<>();
               listForAddWord.add(string);
               agroupsWords.put(word, listForAddWord);
           }
        }

        return new ArrayList<>(agroupsWords.values());
    }

    public static int[] twoSum(int[]arrays, int target){
//        Input: int[] nums = [2, 7, 11, 15], target = 9
//        Output: [0, 1]
//        Explanation: The numbers at indices 0 and 1 in the array add up to the target 9.

        HashMap<Integer, Integer> memoization = new HashMap<>();

        for(int i = 0; i < arrays.length; i++){
            int remain = target - arrays[i];
            if(memoization.containsKey(remain)){
                return new int[]{memoization.get(remain), i };
            }else{
                memoization.put(arrays[i], i);
            }
        }
        return new int[]{};
    }

    public static int[] subarraySum(int[]nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - target)) {
                int start = map.get(sum - target) + 1;
                int end = i;
                return new int[]{start, end};
            }

            map.put(sum, i);
        }

        return new int[]{};
    } //Revazer esse aqui

}
