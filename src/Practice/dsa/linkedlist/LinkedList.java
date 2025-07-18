package Practice.dsa.linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value){
        Node node = new Node(value);
        head = node;
        tail = node;
        length = 1;
    }

    public class Node { //Inner class to create a Node
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public void append(int value){
        Node newNode = new Node(value); //Space complexity O(1)
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = tail.next;
        }
        length++; //Time Complexity O(1), because we only append the value on the tail, we don't have to explore the entire list
    }

    public Node removeLast(){
        if(length == 0) return null;

        Node temp = head; //O(1) Space

        if(length == 1){
            head = null;
            tail = null;
            length = 0;
            return temp;
        }


        while(temp.next.next != null){ //O(n) for remove last
            temp = temp.next;
        }

        tail = temp;
        tail.next = null;
        length--;
        return temp;
    }

    public void prepend(int value){
        Node newNode = new Node(value); //Space complexity O(1)
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            Node temp = head;
            head = newNode;
            head.next = temp;
        }

        length++; //Time Complexity O(1) we just get a reference of the head and set a value before.
    }

    public void printAll(){
        StringBuilder result = new StringBuilder();
        Node temp = head;

        while(temp != null){
            result.append(" ").append(temp.value);
            temp = temp.next;
        }
        System.out.println("LinkedList:" + result);
    }

    public Node removeFirst(){
        if(length == 0) return null;
        Node temp = head;
        head = head.next;
        length--;
        if(length == 0){
            tail = null;
        }
        return temp;
    }

    public Node get(int index){
        if(index >= length  || index < 0) return null;

        Node temp = head;

        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value){
        if(index >= length  || index < 0) return false;

        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        if(temp == null) return false;

        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value){
        if(index > length  || index < 0) return false;

        if(index == 0){
            prepend(value);
            return true;
        }

        if (index == length){
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node beforeNode = get(index - 1);

        Node temp = beforeNode.next;
        beforeNode.next = newNode;
        newNode.next = temp;

        length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0  || index > length) return null;

        if(index == 0) return removeFirst();
        if(index == length) return removeLast();

        Node prev = get(index - 1);
        Node toRemove = prev.next;

        prev.next = toRemove.next;
        toRemove.next = null;
        length--;
        return toRemove;
    }

    public void reverse(){
        //INPUT 13 4 9 5 2 1 10 20

        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;

        for(int i = 0; i < length; i ++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }

        //OUTPUT 20 10 1 2 5 9 4 13
    }

    public void getTail(){
        System.out.println("Tail: " + tail.value);
    }

    public void getLength(){
        System.out.println("Length: " + length);
    }

}
