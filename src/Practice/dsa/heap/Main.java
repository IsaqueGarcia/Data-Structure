package Practice.dsa.heap;

import Practice.leetcode.heap.LastStoneWeight;

public class Main {

    public static void main(String[] args) {

//        Heap heap = new Heap();
//        int[] array = new int[]{60,50,80,40,30,10,70,20,90};
//        heap.heapify(array);
//
//        System.out.println(heap.root);

        LastStoneWeight lst = new LastStoneWeight();
        System.out.println(lst.lastStoneWeight(new int[]{2,3,6,2,4}));

        /*KthLargest kthLargest = new KthLargest(3, new int[]{1, 2, 3, 3});
        System.out.println(kthLargest.add(3));   // return 3
        System.out.println(kthLargest.add(5));   // return 3
        System.out.println(kthLargest.add(6));   // return 3
        System.out.println(kthLargest.add(7));   // return 5
        System.out.println(kthLargest.add(8));   // return 6*/
    }



}
