package linkedList;

public class LinkedList {

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
        Node next;

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

}
