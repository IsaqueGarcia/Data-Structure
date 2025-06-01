package hashtable.leetcode;

public class FindDuplicates {

//    public static ArrayList<Integer> findDuplicates(int[] nums){
//        HashMap<Integer, Boolean> storedNums = new HashMap<>();
//        ArrayList<Integer> duplicatedValues = new ArrayList<>();
//
//        for(int i = 0; i < nums.length; i++){
//            if(storedNums.get(nums[i]) != null){
//                if(!duplicatedValues.contains(nums[i])){
//                    duplicatedValues.add(nums[i]);
//                }
//            }else{
//                storedNums.put(nums[i], true);
//            }
//        }
//
//        return duplicatedValues;
//    }


//    public static List<Integer> findDuplicates(int[] nums) {
//        Map<Integer, Integer> numCounts = new HashMap<>();
//        for (int num : nums) {
//            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
//        }
//        List<Integer> duplicates = new ArrayList<>();
//        for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
//            if (entry.getValue() > 1) {
//                duplicates.add(entry.getKey());
//            }
//        }
//        return duplicates;
//    }

}

