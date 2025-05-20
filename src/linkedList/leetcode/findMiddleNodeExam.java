package linkedList.leetcode;

import linkedList.LinkedList;

public class findMiddleNodeExam {

    //Floyd's Tortoise and Hare algorithm

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        LinkedList.Node middleNode = findMiddleNode(linkedList);

        System.out.println(middleNode.value);
    }


    public static LinkedList.Node findMiddleNode(LinkedList list){

        LinkedList.Node temp = list.getHead();
        LinkedList.Node middleNode = list.getHead();

        while(temp != null && temp.next != null){
            temp = temp.next.next;
            middleNode = middleNode.next;
        }

        return middleNode;
    }

}
