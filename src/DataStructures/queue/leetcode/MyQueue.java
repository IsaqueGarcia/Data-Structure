package DataStructures.queue.leetcode;

import java.util.Stack;

public class MyQueue {

    public static void main(String[] args) {

        // Create a new DataStructures.queue
        MyQueue q = new MyQueue();

        // Enqueue some values
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        // Output the front of the DataStructures.queue
        System.out.println("Front of the DataStructures.queue: " + q.peek());

        // Dequeue some values
        System.out.println("Dequeued value: " + q.dequeue());
        System.out.println("Dequeued value: " + q.dequeue());

        // Enqueue another value
        q.enqueue(4);

        // Output the front of the DataStructures.queue again
        System.out.println("Front of the DataStructures.queue: " + q.peek());

        // Dequeue all remaining values
        System.out.println("Dequeued value: " + q.dequeue());
        System.out.println("Dequeued value: " + q.dequeue());

        // Check if the DataStructures.queue is empty
        System.out.println("Is the DataStructures.queue empty? " + q.isEmpty());

        // Dequeue from an empty DataStructures.queue and check if it returns null
        System.out.println("Dequeued value from empty DataStructures.queue: " + q.dequeue());


        /*
            EXPECTED OUTPUT:
            ----------------
            Front of the DataStructures.queue: 1
            Dequeued value: 1
            Dequeued value: 2
            Front of the DataStructures.queue: 3
            Dequeued value: 3
            Dequeued value: 4
            Is the DataStructures.queue empty? true
            Dequeued value from empty DataStructures.queue: null
        */

    }

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public Integer dequeue(){
        if(stack1.isEmpty()) return null;

        return stack1.pop();
    }

    public void enqueue(int value){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        stack1.push(value);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

    }

    public int peek() {
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
