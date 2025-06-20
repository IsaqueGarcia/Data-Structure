package DataStructures.doublyLinkedList;

public class DoublyLinkedList {


    public static void main(String[] args) {
        DoublyLinkedList myDLL1 = new DoublyLinkedList(3);
        myDLL1.append(8);
        myDLL1.append(5);
        myDLL1.append(10);
        myDLL1.append(2);
        myDLL1.append(1);

        myDLL1.printList();
        myDLL1.partitionList(5);
        System.out.println("==============");
        myDLL1.printList();

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

    public void reverse(){
        //Revert the nodes of the list
        //Validate one node and null nodes
        //1 2 3 4 5 -> 5 4 3 2 1

        if(head == null) return;
        if(lenght == 1) return;

        Node current = head;
        Node temporary = null;

        while(current != null){
            temporary = current.prev; //null
            current.prev = current.next; //2
            current.next = temporary; //null
            current = current.prev;

        }

        temporary = head;
        head = tail;
        tail = temporary;

    }

    public void partitionList(int x) {
        //   +===================================================+
        //   |               WRITE YOUR CODE HERE                |
        //   | Description:                                      |
        //   | - Partitions a doubly linked list around a value  |
        //   |   `x`.                                            |
        //   | - Nodes with values less than `x` come before     |
        //   |   nodes with values greater than or equal to `x`. |
        //   |                                                   |
        //   | Behavior:                                         |
        //   | - Uses two dummy nodes to build two sublists:     |
        //   |   one for < x, one for >= x.                      |
        //   | - Traverses the list, linking nodes to the        |
        //   |   appropriate sublist and updating prev pointers. |
        //   | - Joins the two sublists together.                |
        //   | - Updates the head and resets head.prev to null.  |
        //   +===================================================+
        if(head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node less = dummy1;
        Node more = dummy2;
        Node current = head;

        while(current != null){

            if(current.value >= x){

                more.next = current;
                current.prev = more;
                more = current;

            }else{

                less.next = current;
                current.prev = less;
                less = current;

            }

            current = current.next;
        }

        more.next = null;
        less.next = dummy2.next;

        if(dummy2.next != null){
            dummy2.next.prev = less;
        }

        head = dummy1.next;

        if(head != null){
            head.prev = null;
        }
    }

    public void reverseBetween(int startIndex, int endIndex) {
        //   +===================================================+
        //   |               WRITE YOUR CODE HERE                |
        //   | Description:                                      |
        //   | - Reverses a portion of a doubly linked list      |
        //   |   between two indices (inclusive range).          |
        //   | - Only nodes between startIndex and endIndex are  |
        //   |   reversed in place.                              |
        //   |                                                   |
        //   | Behavior:                                         |
        //   | - A dummy node simplifies handling edge cases.    |
        //   | - `prev` is positioned just before the reversal.  |
        //   | - Nodes are relocated one at a time to reverse    |
        //   |   their order within the specified segment.       |
        //   | - All `next` and `prev` pointers are correctly    |
        //   |   updated to maintain list integrity.             |
        //   | - The head pointer is reset at the end.           |
        //   +===================================================+

        if(head == null) return;

        Node dummy1 = new Node(0); //For keep the reference of the first pointer
        dummy1.next = head;
        Node current = head;
        Node prev = null;

        for(int i = 0; i < startIndex; i++){
            current = current.next;
        }

        prev = current;

        for(int i = startIndex; i < endIndex; i++){
            Node moveTo = current.next;

            current.next = prev;
            current = moveTo;
            current.next.prev = moveTo;

            current = current.next;
            prev = prev.next;
        }

        head = dummy1.next;

//        if(head == null) return;
//        if(startIndex == endIndex) return;
//
//        Node dummy1 = new Node(0); //For keep the reference of the first pointer
//        dummy1.next = head;
//        head.prev = dummy1;
//        Node prev = dummy1;
//
//        for(int i = 0; i < startIndex ; i++){
//            prev = prev.next;
//        }
//
//        Node current = prev.next;
//
//        for(int i = startIndex; i < endIndex; i++){
//            Node moveTo = current.next;
//
//            current.next = moveTo.next;
//
//            if(moveTo.next != null){
//                moveTo.next.prev = current;
//            }
//
//            moveTo.next = prev.next;
//            prev.next.prev = moveTo;
//
//            prev.next = moveTo;
//            moveTo.prev = prev;
//        }
//
//        head = dummy1.next;
//        head.prev = null;
    }

}
