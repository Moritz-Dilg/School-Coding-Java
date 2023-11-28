package testing.LinkedList;

public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Method to insert a new node at the end of the linked list
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void prepend(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
        }

        head = newNode;
    }

    public int popFront() throws EmptyListException {
        if (head == null) throw new EmptyListException("Cannot pop from an empty linked list");

        Node current = head;
        head = head.next;

        return current.data;
    }

    public int popBack() throws EmptyListException {
        if (head == null) throw new EmptyListException("Cannot pop from an empty linked list");

        Node current = head;
        Node previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            head = null;
            return current.data;
        }

        previous.next = null;

        return current.data;
    }

    @Override
    public String toString() {
        if (head == null) return "";

        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current.next != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        sb.append(current.data);

        return sb.toString();
    }
}

