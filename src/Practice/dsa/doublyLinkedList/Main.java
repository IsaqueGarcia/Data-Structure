package Practice.dsa.doublyLinkedList;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList(1);

        doublyLinkedList.append(2);
        doublyLinkedList.append(3);
        doublyLinkedList.append(4);
        doublyLinkedList.append(5);

        doublyLinkedList.printAll();

        System.out.println("Removing...");

        doublyLinkedList.removeLast();

        doublyLinkedList.printAll();

        System.out.println("Prepend...");

        doublyLinkedList.prepend(5);

        doublyLinkedList.printAll();

        System.out.println("Remove first...");

        doublyLinkedList.removeFirst();

        doublyLinkedList.printAll();

        System.out.println("Performing some gets");

        System.out.println(doublyLinkedList.get(-1));
        System.out.println(doublyLinkedList.get(0).value);
        System.out.println(doublyLinkedList.get(1).value);
        System.out.println(doublyLinkedList.get(2).value);
        System.out.println(doublyLinkedList.get(3).value);
        System.out.println(doublyLinkedList.get(4));

        doublyLinkedList.set(3, 11);

        doublyLinkedList.printAll();

        System.out.println("Doing some inserts...");

        doublyLinkedList.insert(1, 12);

        doublyLinkedList.printAll();

        System.out.println(doublyLinkedList.remove(3).value);

        doublyLinkedList.printAll();

    }

}
