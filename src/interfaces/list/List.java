package interfaces.list;

import java.util.Iterator;

public class List implements Iterable<Node> {
    private Node head = null;

    public void add(Comparable<Node> obj) {
        Node n = (Node) obj;
        if (head == null || head.compareTo(n) < 0) {
            n.next = head;
            head = n;
        } else {
            Node pb = head;
            for (Node p : this) {
                if (p.compareTo(n) <= 0) {
                    n.next = p;
                    pb.next = n;
                    return;
                }
                pb = p;
            }

            n.next = pb.next;
            pb.next = n;
        }
    }

    public void remove(Comparable<Node> obj) {
        Node n = (Node) obj;
        Node pb = head;

        if (head.compareTo(n) == 0) head = head.next;
        else {
            for (Node p : this) {
                if (p.compareTo(n) == 0) {
                    pb.next = p.next;
                    return;
                }
                pb = p;
            }
        }
    }

    public void print() {
        for (Node p : this) {
            System.out.print(p + " ");
        }
        System.out.print("\n");
    }

    @Override
    public Iterator<Node> iterator() {
        return new ListIterator(head);
    }

    private static class ListIterator implements Iterator<Node> {
        private Node curr;

        public ListIterator(Node head) {
            this.curr = head;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Node next() {
            Node n = curr;
            curr = curr.next;
            return n;
        }
    }
}
