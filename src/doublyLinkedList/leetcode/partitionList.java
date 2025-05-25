package doublyLinkedList.leetcode;

import doublyLinkedList.DoublyLinkedList;

public class partitionList {

//    public void partitionList(int x) {
//        //   +===================================================+
//        //   |               WRITE YOUR CODE HERE                |
//        //   | Description:                                      |
//        //   | - Partitions a doubly linked list around a value  |
//        //   |   `x`.                                            |
//        //   | - Nodes with values less than `x` come before     |
//        //   |   nodes with values greater than or equal to `x`. |
//        //   |                                                   |
//        //   | Behavior:                                         |
//        //   | - Uses two dummy nodes to build two sublists:     |
//        //   |   one for < x, one for >= x.                      |
//        //   | - Traverses the list, linking nodes to the        |
//        //   |   appropriate sublist and updating prev pointers. |
//        //   | - Joins the two sublists together.                |
//        //   | - Updates the head and resets head.prev to null.  |
//        //   +===================================================+
//        if(head == null) return;
//
//        DoublyLinkedList.Node dummy1 = new DoublyLinkedList.Node(0);
//        DoublyLinkedList.Node dummy2 = new DoublyLinkedList.Node(0);
//        DoublyLinkedList.Node less = dummy1;
//        DoublyLinkedList.Node more = dummy2;
//        DoublyLinkedList.Node current = head;
//
//        while(current != null){
//
//            if(current.value >= x){
//
//                more.next = current;
//                current.prev = more;
//                more = current;
//
//            }else{
//
//                less.next = current;
//                current.prev = less;
//                less = current;
//
//            }
//
//            current = current.next;
//        }
//
//        more.next = null;
//        less.next = dummy2.next;
//
//        if(dummy2.next != null){
//            dummy2.next.prev = less;
//        }
//
//
//
//        head = dummy1.next;
//
//        if(head != null){
//            head.prev = null;
//        }
//    }

}
