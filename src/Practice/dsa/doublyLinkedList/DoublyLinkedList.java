package Practice.dsa.doublyLinkedList;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length++;
    }

    public class Node {
        public int value;
        public Node next;
        public Node prev;
        public Node(int value){this.value = value;}
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
             Node temp = head;
             newNode.next = temp;
             temp.prev = newNode;
             head = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if(length == 0) return null;
        Node temp = tail;

        if(length == 1){
            head = null;
            tail = null;
        }else{
            tail = temp.prev;
            temp.prev = null;
            tail.next = null;
        }

        length--;
        return temp;
    }

    public Node removeFirst(){
        if(length == 0) return null;
        Node temp = head;

        if(length == 1){
            head = null;
            tail = null;
        }else{
            head = head.next;
            head.prev = null;
            temp.next = null;
        }

        length--;
        return temp;
    }

    public Node get(int index){ //I can improve this doing a divided search later...
        if(length == 0 || index > length - 1 || index < 0) return null;
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value){
        if(length == 0 || index > length - 1 || index < 0) return false;
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        temp.value = value;
        return true;
    }

    public boolean insert(int index, int value){
        if(index < 0 || index > length) return false;

        if (index == length){
            append(value);
            return true;
        }

        if (index == 0){
            prepend(value);
            return true;
        }

        Node newNode = new Node(value);

        Node prev = get(index -1);
        Node temp = prev.next;

        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = temp;
        temp.prev = newNode;

        length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index > length) return null;

        if (index == length){
            return removeLast();
        }

        if (index == 0){
            return removeFirst();
        }

        Node prev = get(index - 1);
        Node nodeToRemove = prev.next;

        prev.next = nodeToRemove.next;
        nodeToRemove.next.prev = prev;

        length--;
        return nodeToRemove;
    }

    public void printAll(){
        String result = "";
        Node temp = head;
        while (temp != null){
            result = result.concat(" " + temp.value);
            temp = temp.next;
        }
        System.out.println(result);
    }

}
