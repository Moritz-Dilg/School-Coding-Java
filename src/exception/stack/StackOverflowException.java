package exception.stack;

public class StackOverflowException extends StackException {
    public StackOverflowException(String message, int size) {
        super(message, size);
    }
}
