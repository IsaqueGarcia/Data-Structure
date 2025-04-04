import linkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);

        linkedList.append(2);
        linkedList.append(5);
        linkedList.append(23);
        linkedList.append(40);
        linkedList.printList();

        System.out.println("=======After remove========");
        linkedList.removeLast();
        linkedList.printList();

        System.out.println("=======After include a new node in the begin========");
        linkedList.prepend(15);
        linkedList.printList();

        System.out.println("=======After remove the first node========");
        linkedList.removeFirst();
        linkedList.printList();

        System.out.println("=======Get by index========");
        System.out.println("Index (2), value: " + linkedList.get(2).value);

        System.out.println("=======Set by index========");
        linkedList.set(2,10);
        linkedList.printList();

        System.out.println("=======Insert========");
        linkedList.insert(0, 33);
        linkedList.insert(linkedList.getLength(), 44);
        linkedList.insert(3,55);
        linkedList.printList();

        System.out.println("=======Remove========");
        linkedList.remove(linkedList.getLength() - 1);
        linkedList.printList();

        System.out.println("=======Reverse========");
        linkedList.reverse();
        linkedList.printList();
    }
}