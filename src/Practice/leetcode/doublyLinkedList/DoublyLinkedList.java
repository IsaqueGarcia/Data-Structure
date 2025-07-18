package Practice.leetcode.doublyLinkedList;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
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
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append (int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }


    public boolean isPalindrome(){

        if(length == 1){
            return  true;
        }

        Node leftNode = head;
        Node rightNode = tail;

        for (int i = 0; i < length / 2; i++){
            if(leftNode.value != rightNode.value){
                return false;
            }

            leftNode = leftNode.next;
            rightNode = rightNode.prev;
        }

        return true;
    }

    public void reverse(){

        Node currentNode = head;
        Node temporary = null;

        while(currentNode != null){
            temporary = currentNode.prev; //Salva o próximo node, semelhante ao reverse da linked list

            //Troca os ponteiros, o nó anterior passa a ser o próximo nó, e o próximo recebe o nó anterior
            currentNode.prev = currentNode.next;
            currentNode.next = temporary;

            //Avança para a próxima execução
            currentNode = currentNode.prev;
        }

        Node prevHead = head;
        head = tail;
        tail = prevHead;

    }

    public void partitionList(int x){
        //Input:  3 <-> 8 <-> 5 <-> 10 <-> 2 <-> 1, x = 5
        //Output: 3 <-> 2 <-> 1 <-> 8 <-> 5 <-> 10

        if(head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node less = dummy1;
        Node greater = dummy2;
        Node currentNode = head;

        while (currentNode != null){
            if(currentNode.value >= x){
                greater.next = currentNode;
                currentNode.prev = greater;
                greater = greater.next;
            }else{
                less.next = currentNode;
                currentNode.prev = less;
                less = less.next;
            }
            currentNode = currentNode.next;
        }

        greater = null;
        dummy1.next = dummy2.next;

        if(dummy2.next != null){ //Relink the prev reference
            dummy2.next.prev = less;
        }

        head = dummy1.next;

        if(head != null){ //Clean the prev reference...
            head.prev = null;
        }

    }

    public void reverseBetween(int startIndex, int endIndex){

        if(head == null || startIndex == endIndex) return;

        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;

        Node prev = dummy;

        for(int i = 0; i < startIndex; i++){
            prev = prev.next;
        }

        Node current = prev.next;

        for(int i = 0; i < endIndex - startIndex; i++){
            Node nodeToMove = current.next;
            current.next = nodeToMove.next;

            if(nodeToMove.next != null) {
                nodeToMove.next.prev = current;
            }

            nodeToMove.next = prev.next;
            prev.next.prev = nodeToMove;

            prev.next = nodeToMove;
            nodeToMove.prev = prev;
        }

        head = dummy.next;
        head.prev = null;

    }

//    public void swapPairs(){
//        if(head == null || head.next == null) return;
//
//        Node dummy = new Node(0);
//        dummy.next = head;
//
//        Node current = dummy.next;
//        Node pair = current.next;
//        Node prev = null;
//
//        while(pair != null){
//            Node nextPairs = pair.next;
//
//            pair.next = current;
//            pair.prev = prev;
//            current.next = nextPairs;
//            current.prev = pair;
//
//            //if(current.next != null){
//                current = current.next;
//            //}
//
//            prev = pair.next;
//            current.prev = prev;
//            pair = current.next;
//
//        }
//
//        head = dummy.next;
//    }


}
