package Practice.leetcode.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones){
            maxHeap.add(stone);
        }

        if(maxHeap.size() <= 1) return maxHeap.size();

        while(maxHeap.size() > 1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(x - y > 0){
                maxHeap.add(x-y);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }

}
