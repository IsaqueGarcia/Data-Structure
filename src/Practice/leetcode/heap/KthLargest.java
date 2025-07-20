package Practice.leetcode.heap;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int kth;

    public KthLargest(int k, int[] nums) {
        this.kth = k;
        for(int num : nums){
            minHeap.add(num);
        }
        while(minHeap.size() > k){
            minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.add(val);
        while(minHeap.size() > kth){
            minHeap.poll();
        }
        return minHeap.peek();
    }


}
