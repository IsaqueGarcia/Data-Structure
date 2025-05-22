package linkedList;

import java.util.HashSet;

public class LinkedList {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);

        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);

        linkedList.printList();
        linkedList.swapPairs();
        linkedList.printList();
//        linkedList.printList();
//
//        System.out.println("=======After remove========");
//        linkedList.removeLast();
//        linkedList.printList();
//
//        System.out.println("=======After include a new node in the begin========");
//        linkedList.prepend(15);
//        linkedList.printList();
//
//        System.out.println("=======After remove the first node========");
//        linkedList.removeFirst();
//        linkedList.printList();
//
//        System.out.println("=======Get by index========");
//        System.out.println("Index (2), value: " + linkedList.get(2).value);
//
//        System.out.println("=======Set by index========");
//        linkedList.set(2,10);
//        linkedList.printList();
//
//        System.out.println("=======Insert========");
//        linkedList.insert(0, 33);
//        linkedList.insert(linkedList.getLength(), 44);
//        linkedList.insert(3,55);
//        linkedList.printList();
//
//        System.out.println("=======Remove========");
//        linkedList.remove(linkedList.getLength() - 1);
//        linkedList.printList();
//
//        System.out.println("=======Reverse========");
//        linkedList.reverse();
//        linkedList.printList();
    }


    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value){
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public static class Node {

        public int value;
        public Node next;

        public Node(int value){
            this.value = value;
        }

    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            //This order is important to follow
            tail.next = newNode; //Receive the next node on this tail
            tail = newNode; //Set the new tail
        }
        length++;
    }

    public Node removeLast(){
        if(length == 0) return null;

        Node temp = head;
        Node pre = head;

        while(temp.next != null){
            pre = temp; //Pre is always one step behind temp for set the new tail
            temp = temp.next; //Gets the next value until this value equals null
        }

        tail = pre; //new tail
        tail.next = null; //remove the last value
        length--;

        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    public void prepend(int value){

        Node newNode = new Node(value);

        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if(length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null; //Remove the reference
        length--;
        if(length == 0){
            tail = null;
        }
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length) return null;

        Node temp = head;

        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        return  temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > length) return false;

        if(index == 0) { prepend(value); return true; };
        if(index == length) { append(value); return true; };

        Node temp = get(index - 1);
        Node newNode = new Node(value);

        newNode.next = temp.next;
        temp.next = newNode;
        length++;

        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= length) return null;
        if(index == 0 ) return removeFirst();
        if(index == length -1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for(int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

    }


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
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
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void removeDuplicates(){

        Node start = head; //Initial pointer
        HashSet<Integer> previousNumber = new HashSet<Integer>();

        while(start != null){

            if(previousNumber.contains(start.value)){
                Node temp = start.next;
                start = null;
                start = temp;
            }

            previousNumber.add(start.value);
            start = start.next;
        }


    }

    public void reverseBetween(int m, int n){

        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        Node current = head;
        Node toMove = current.next;

        for(int i = 0; i < m; i++){ //Move the pointer to start revert
            current = current.next;
            prev = prev.next;
            toMove = toMove.next;
        }

        for(int i = m; i < n; i++){
            current.next = toMove.next;
            toMove.next = prev.next;
            prev.next = toMove;

            //current = current.next;
            toMove = current.next;
        }

        head = dummy.next;

    }

    public void swapPairs() {

        if(head == null) return;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        Node first = head;

        //1 - 2 - 3 - 4

        while(first != null && first.next != null){

            Node second = first.next;

            prev.next = second; //2 / 4
            first.next = second.next; //3 / null
            second.next = first; //1 / 3

            prev = first; //in the same point
            first = first.next; //move to the next first

        }

        head = dummy.next;

    }

}
