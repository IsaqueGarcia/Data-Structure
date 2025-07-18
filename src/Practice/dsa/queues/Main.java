package Practice.dsa.queues;

public class Main {

    public static void main(String[] args) {

        Queue queue = new Queue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        //queue.printList();

        System.out.println("Removed: " + queue.dequeue().value);
        System.out.println("Removed: " + queue.dequeue().value);
        System.out.println("Removed: " + queue.dequeue().value);

        System.out.println("First: " + queue.getFirst().value);
        System.out.println("Last: " + queue.getLast().value);

        queue.printList();

    }

}
