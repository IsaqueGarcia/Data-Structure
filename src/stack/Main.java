package stack;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack(2);
        stack.push(1);
        stack.push(23);
        stack.push(50);
        stack.printStack();
        System.out.println("\n");
        stack.pop();
        stack.printStack();

        stack.getTop();
        stack.getHeight();
    }

}
