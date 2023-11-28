package matura.patterns.iterator;

public class Node<T extends Comparable<T>> {
    T val;
    Node<T> left;
    Node<T> right;

    public Node(T val) {
        this.val = val;
    }
}
