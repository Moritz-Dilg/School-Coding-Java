package exception.stack;

public class StackException extends Exception {
    protected final int stackSize;
    public StackException(String message, int size) {
        super(message);
        stackSize = size;
    }

    @Override
    public String toString() {
        return getMessage() + " - Stack size: " + stackSize;
    }
}
