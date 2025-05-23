package doublyLinkedList;

public class DoublyLinkedList {


    public static void main(String[] args) {
        DoublyLinkedList myDLL1 = new DoublyLinkedList(1);
        myDLL1.append(2);
        myDLL1.append(3);
        myDLL1.append(2);
        myDLL1.append(1);

        System.out.println("myDLL1 isPalindrome:");
        System.out.println( myDLL1.isPalindrome() );

        DoublyLinkedList myDLL2 = new DoublyLinkedList(1);
        myDLL2.append(2);
        myDLL2.append(3);

        System.out.println("\nmyDLL2 isPalindrome:");
        System.out.println( myDLL2.isPalindrome() );

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

    public void append(int value){
        Node newNode = new Node(value);
        if(lenght == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        lenght++;
    }

    public void prepend(int value){
        Node newNode = new Node(value);

        if(lenght == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        lenght++;
    }

    public Node removeLast(){

        if(lenght == 0) return null;

        Node temp = tail;

        if(lenght == 1){
            head = null;
            tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }

        lenght--;
        return temp;
    }

    public Node removeFirst(){
        if(lenght == 0) return null;
        Node temp = head;
        if(lenght == 1){
            head = null;
            tail = null;
        }else{
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        lenght--;
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= lenght) return null;

        Node temp = head;

        if(lenght < lenght/2){ //Divide the linked list to perform the best search

            for(int i = 0; i < index; i++){
                temp = temp.next;
            }

        }else{

            temp = tail;
            for(int i = lenght - 1; i > index; i--){
                temp = temp.prev;
            }

        }
        return temp;
    }

    public boolean set(int index, int value){
        Node node = get(index);
        if(node != null){
            node.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > lenght) return false;

        if(index == 0){
            prepend(value);
            return true;
        }

        if(index == lenght){
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        lenght++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index > lenght) return null;

        if(index == 0){ return removeFirst(); }
        if(index == lenght) { return removeLast(); }

        Node nodeToRemove = get(index);
        nodeToRemove.next.prev = nodeToRemove.prev;
        nodeToRemove.prev.next = nodeToRemove.next;
        nodeToRemove.next = null;
        nodeToRemove.prev = null;
        lenght--;
        return nodeToRemove;
    }

    /** Util's get **/

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
        System.out.println("Length: " + lenght);
    }

    public boolean isPalindrome(){

        if(lenght == 1){
            return  true;
        }

        Node n1 = head;
        Node n2 = tail;

        for(int i = 0; i < lenght / 2;i++){

            n2 = n2.prev;
            n1 = n1.next;

            if(n2.value != n1.value){
                return false;
            }

        }

        return true;
    }

}
