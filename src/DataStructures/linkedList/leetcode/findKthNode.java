package DataStructures.linkedList.leetcode;

public class findKthNode {

    /***
     * This is a common technique in computer science known as the 'fast-pointer / slow-pointer'
     * or 'runner' technique,
     * and it's a neat way of finding a position relative to the end of a list in a single pass.
     */
    
   /* public Node findKthFromEnd(int k){
        Node fast = head;
        Node slow = head;

        for(int i = 0; i < k; i++){


            if(fast == null){
                return null;
            }

            fast = fast.next;
        }

        // K = 2
        // 1(slow), 3, 6 (fast), 2, 5
        // After this we will increment step by step until the fast becomes null, so in this case
        //slow represents the Kth node and return = 2

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }*/

}
