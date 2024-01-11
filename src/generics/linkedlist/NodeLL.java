package generics.linkedlist;

public class NodeLL<T> {
    T val;
    NodeLL<T> next;

    public NodeLL(T val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}