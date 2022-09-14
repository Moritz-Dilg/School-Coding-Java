package exception.stack;

public class StackUnderflowException extends StackException {
    public StackUnderflowException(String message, int size) {
        super(message, size);
    }
}
