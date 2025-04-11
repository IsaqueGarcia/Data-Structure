package doublyLinkedList;

public class DoublyLinkedList {


    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(10);

        doublyLinkedList.printList();
        doublyLinkedList.getHead();
        doublyLinkedList.getTail();
        doublyLinkedList.getLenght();

    }


    Node head;
    Node tail;
    int lenght;

    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        lenght = 1;
    }

    class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value){
            this.value = value;
        }
    }

    public void printList(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead(){
        System.out.println("Head: " + head.value);
    }

    public void getTail(){
        System.out.println("Tail: " + tail.value);
    }

    public void getLenght(){
        System.out.println("Lenght: " + lenght);
    }
}
