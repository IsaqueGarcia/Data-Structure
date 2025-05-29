package Challenges;

import java.util.ArrayList;

public class Stack<T> {


   public static boolean isBalancedParentheses(String parantheses){

       Stack<Character> myStack = new Stack<>();
       if(parantheses.isEmpty()) return true;

       for(Character x : parantheses.toCharArray()){
           if(x.equals('(')){
               myStack.push(x);
           }else{
               if(myStack.isEmpty()){
                   return false;
               }
               myStack.pop();
           }
       }

       return myStack.isEmpty();
   }

//    public static void sortStack(Challenges.Stack<Integer> stack){
//        //2 - 4 - 1 - 3
//
//        Challenges.Stack<Integer> sortingStack = new Challenges.Stack<>();
//
//        while (!stack.isEmpty()){
//            Integer temp = stack.pop(); // get the last element
//
//            while(!sortingStack.isEmpty() && sortingStack.peek() > temp){
//                Integer top = sortingStack.pop();
//                stack.push(top);
//                //sortingStack.push(temp);
//            }
//
//            sortingStack.push(temp);
//        }
//
//        while (!sortingStack.isEmpty()){
//            stack.push(sortingStack.pop());
//        }
//
//    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Before sorting:");
        stack.printStack();

        //sortStack(stack);

        System.out.println("\nAfter sorting:");
        stack.printStack();

        /*
            EXPECTED OUTPUT:
            ----------------
            Before sorting:
            4
            1
            5
            2
            3

            After sorting:
            1
            2
            3
            4
            5

        */

    }

    public static void testAndPrint(String testStr, boolean expected) {
        // Run the test and store the result
        boolean result = isBalancedParentheses(testStr);

        // Print the test string, expected result, and actual result
        System.out.println("Test String: " + testStr);
        System.out.println("EXPECTED: " + expected);
        System.out.println("RESULT: " + result);

        // Check if the test passed or failed
        if (result == expected) {
            System.out.println("STATUS: PASS");
        } else {
            System.out.println("STATUS: FAIL");
        }

        // Print a separator for better readability
        System.out.println("--------------");
    }

    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(T value) {
        stackList.add(value);
    }

    public T pop(){

        if(size() == 0){
            return null;
        }

        return stackList.remove(size() - 1);
    }


}
