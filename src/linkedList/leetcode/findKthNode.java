package linkedList.leetcode;

public class findKthNode {

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
