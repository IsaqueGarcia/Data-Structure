package queue;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue(1);
        queue.enqueue(2); // O(1)
        queue.enqueue(3);

        queue.printQueue();

        queue.dequeue(); // O(1)

        queue.printQueue();


    }

}
