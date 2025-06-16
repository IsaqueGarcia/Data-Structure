package binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    Node root;

    public BinarySearchTree(){};

    static class Node {
        int value;
        Node right;
        Node left;

        public Node(int value){
            this.value = value;
        }
    }

    public boolean insert(int value){
        Node newNode = new Node(value);

        if(root == null){
            root = newNode;
            return true;
        }

        Node temp = root;

        while(true){
            if(temp.value == newNode.value){ return false;}

            if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }else{
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }

    }

    public void rInsert(int value){
        if(root == null) root = new Node(value);
        rInsert(root, value);
    }

    private Node rInsert(Node currentNode, int value){
        if(currentNode == null) return new Node(value);

        if(value < currentNode.value){
            currentNode.left = rInsert(currentNode.left, value);
        }else if(value > currentNode.value){
            currentNode.right = rInsert(currentNode.right, value);
        }

        return currentNode;
    }

    public boolean contains(int value){ //Big O(log n)
        Node temp = root;
        while(temp != null){
            if(value < temp.value){
                temp = temp.left;
            }else if(value > temp.value){
                temp = temp.right;
            }else{
                return true;
            }
        }
        return false;
    }

    public boolean rContains(int value){
        return rContains(root, value);
    }

    private boolean rContains(Node currentNode, int value){
        if(currentNode == null) return false;
        if(currentNode.value == value) return true;

        if(value < currentNode.value){
            return rContains(currentNode.left, value);
        }else{
            return rContains(currentNode.right, value);
        }
    }

    public void deleteNode(int value){
        deleteNode(root, value);
    }

    private Node deleteNode(Node currentNode, int value){
        if(currentNode == null) return null;

        if(value < currentNode.value){
            currentNode.left = deleteNode(currentNode.left, value);
        }else if(value > currentNode.value){
            currentNode.right = deleteNode(currentNode.right, value);
        }else{
            if(currentNode.left == null && currentNode.right == null){
                return null;
            }else if(currentNode.left == null){
                currentNode = currentNode.right; //The garbage will collect the previous node that we removed
            }else if(currentNode.right == null){
                currentNode = currentNode.left;
            }else{
                int subTree = minValue(currentNode.right);
                currentNode.value = subTree;
                currentNode.right = deleteNode(currentNode.right, subTree);
            }
        }

        return currentNode;
    }

    public int minValue(Node currentNode){
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public ArrayList<Integer> BFS(){
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(currentNode);

        while(!queue.isEmpty()){
           currentNode = queue.remove();
           result.add(currentNode.value);
           if(currentNode.left != null){
               queue.add(currentNode.left);
           }
           if(currentNode.right != null){
               queue.add(currentNode.right);
           }
        }
        return result;
    }

    public ArrayList<Integer> DFSPreOrder(){
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse {
            Traverse(Node current){
                result.add(current.value);
                if(current.left != null){
                    new Traverse(current.left);
                }

                if(current.right != null){
                    new Traverse(current.right);
                }
            }
        }

        new Traverse(root);
        return result;

    }

    public ArrayList<Integer> DFSPostOrder(){
        ArrayList<Integer> result = new ArrayList<>();
        class Traverse {
            Traverse(Node current){
                if(current.left != null){
                    new Traverse(current.left);
                }
                if(current.right != null){
                    new Traverse(current.right);
                }
                result.add(current.value);
            }
        }
        new Traverse(root);
        return result;
    }

    public ArrayList<Integer> DFSInOrder(){
        ArrayList<Integer> result = new ArrayList<>();
        class Traverse {
            Traverse(Node current){
                if(current.left != null){
                    new Traverse(current.left);
                }
                result.add(current.value);
                if(current.right != null){
                    new Traverse(current.right);
                }
            }
        }
        new Traverse(root);
        return result;
    }

}
