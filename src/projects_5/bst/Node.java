package projects_5.bst;

public class Node <T extends Comparable<T>> {
    private final T value;
    private Node<T> left;
    private Node<T> right;

    Node (T data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }

    public T getValue() {
        return this.value;
    }

    public Node<T> getLeft() {
        return this.left;
    }

    public Node<T> getRight() {
        return this.right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }
}
