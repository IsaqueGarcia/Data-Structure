package Practice.dsa.trees;

public class Tree {

    private Node root;

    public Tree(){};

    public class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value){
        Node newNode = new Node(value);

        if(root == null){
            root = newNode;
            return true;
        }

        Node temp = root;

        while (true){
            if(temp.value == newNode.value){
                return false;
            }

            if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
            if(newNode.value > temp.value){
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value){
        if(root == null) return false;

        Node temp = root;

        while (temp != null){
            if(temp.value == value){
                return true;
            }
            if(value < temp.value){
                temp = temp.left;
            }else {
                temp = temp.right;
            }
        }
        return false;
    }
}
