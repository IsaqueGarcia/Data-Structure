package Practice.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    public Node findMiddleNode(){
        //Find the middle node and return
        //If the list has an even number of nodes, the method should return the second middle node.
        //Maybe i can use two pointers here...

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean hasLoop(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public Node findKthFromEnd(int k){

        Node kTh =  head;
        Node fast = head;

        for(int i = 1; i < k; i++){
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }

        while(fast != null && fast.next != null){
            kTh = kTh.next;
            fast = fast.next;
        }

        if(fast == null){
            return null;
        }

        return kTh;
    }

    public void removeDuplicates() {
        Node temp = head;
        Node prev = null;
        Set<Integer> values = new HashSet<>();
        while(temp != null){
            if(values.contains(temp.value)){
                prev.next = temp.next;
                length--;
            }else{
                prev = temp;
                values.add(temp.value);
            }
            temp = temp.next;
        }
    }
}
