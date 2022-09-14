package exception.stack;

public class Stack<T> {
    private final T[] data;
    private int top = 0;

    Stack(int size) {
        data =  (T[]) new Object[size];
    }

    public void push(T item) throws StackOverflowException {
        if (top >= data.length) {
            throw new StackOverflowException("Stack overflow", data.length);
        }
        data[top++] = item;
    }

    public T pop() throws StackUnderflowException {
        if (top <= 0) {
            throw new StackUnderflowException("Stack underflow", data.length);
        }
        return data[--top];
    }
}
