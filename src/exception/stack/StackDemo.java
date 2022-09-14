package exception.stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(3);
        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
        } catch (StackOverflowException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
        try {
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
        } catch (StackUnderflowException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
