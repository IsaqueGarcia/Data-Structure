package Practice.dsa.queues;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    public Queue(int value){
        Node newNode = new Node(value);
        this.first = newNode;
        this.last = newNode;
        length = 1;
    }

    public class Node {
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length == 0){
            first = newNode;
            last = newNode;
        }else{
            Node temp = last;
            last = newNode;
            last.next = temp;
        }
        length++;
    }

    public Node dequeue(){
        if(length == 0) return null;

        Node temp = last;

        if(length == 1){
            last = null;
            first = null;
        }else{
            while (temp.next.next != null){
                temp = temp.next;
            }
            first = temp;
            temp = first.next;
            first.next = null;
        }

        length--;
        return temp;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = last;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

}
