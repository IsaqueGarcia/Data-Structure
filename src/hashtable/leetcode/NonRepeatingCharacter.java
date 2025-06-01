package hashtable.leetcode;

public class NonRepeatingCharacter {

//    public static Character firstNonRepeatingChar(String word){
//        char[] chars =  word.toCharArray();
//        Map<Character, Integer> map = new HashMap<>();
//
//        for(Character x : chars){
//            map.put(x, map.getOrDefault(x, 0) + 1);
//        }
//
//        for(Map.Entry<Character, Integer> entry : map.entrySet()){
//            if(entry.getValue() == 1){
//                return entry.getKey();
//            }
//        }
//
//        return null;
//    }


//    public static Character firstNonRepeatingChar(String string) {
//        Map<Character, Integer> charCounts = new HashMap<>();
//
//        for (int i = 0; i < string.length(); i++) {
//            char c = string.charAt(i);
//            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
//        }
//
//        for (int i = 0; i < string.length(); i++) {
//            char c = string.charAt(i);
//            if (charCounts.get(c) == 1) {
//                return c;
//            }
//        }
//
//        return null;
//    }

}
