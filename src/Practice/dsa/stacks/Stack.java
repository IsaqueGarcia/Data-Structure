package Practice.dsa.stacks;

public class Stack {

    private Node top;
    private int height;

    public Stack(int value){
        this.top = new Node(value);
        height = 1;
    }

    public class Node {
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public void push(int value){
        Node newNode = new Node(value);

        if(height == 0){
            top = newNode;
            height = 1;
            return;
        }

        Node temp = top;
        top = newNode;
        newNode.next = temp;
        height++;
    }


    public Node pop(){
        if(height == 0) return null;

        Node temp = top;

        if(height == 1){
            top = null;
        }else{
            top = top.next;
            temp.next = null;
        }

        height--;
        return temp;
    }

    public void printStack() {
        String result = "";
        Node temp = top;
        while (temp != null) {
            result = result.concat(" ").concat(String.valueOf(temp.value));
            temp = temp.next;
        }
        System.out.println(result);
    }

}
