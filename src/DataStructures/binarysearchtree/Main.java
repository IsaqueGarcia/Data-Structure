package DataStructures.binarysearchtree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

//        bst.rInsert(2);
//        bst.rInsert(1);
//        bst.rInsert(3);
//
//        bst.deleteNode(2);
//
//        System.out.println("Root value ==> " + bst.root.value);
//        System.out.println("Root left ==> " + bst.root.left.value);
//        System.out.println("Root right ==> " + bst.root.right);

        bst.insert(47);
        bst.insert(21);
        bst.insert(76);
        bst.insert(18);
        bst.insert(27);
        bst.insert(52);
        bst.insert(82);

        System.out.println(bst.BFS());
        System.out.println(bst.DFSPreOrder());
        System.out.println(bst.DFSPostOrder());
        System.out.println(bst.DFSInOrder());


    }

}
