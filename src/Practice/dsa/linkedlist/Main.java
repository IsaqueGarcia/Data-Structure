package Practice.dsa.linkedlist;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(2);
        linkedList.append(1);
        linkedList.append(3);
        linkedList.prepend(1);
        linkedList.prepend(4);

        linkedList.printAll();

        linkedList.set(1,5); //Update by index...
        linkedList.set(4,10);
        linkedList.insert(0,13);
        linkedList.insert(6,20);
        linkedList.insert(2,9);

        linkedList.printAll();

//        System.out.println("The Node " + linkedList.remove(2).value + " was removed");
//        System.out.println("The Node " + linkedList.remove(0).value + " was removed");
//        System.out.println("The Node " + linkedList.remove(5).value + " was removed");

//        System.out.println("Get: " + linkedList.get(5).value);
//        System.out.println("Removing Last...");
//        linkedList.removeLast();
//        linkedList.printAll();
//
//        System.out.println("Removing First...");
//        linkedList.removeFirst();

        linkedList.reverse();

        //Helpers
        linkedList.printAll();
        linkedList.getTail();
        linkedList.getLength();
    }

}
