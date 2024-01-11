package generics.linkedlist;

public class List<T> implements Iterable<T> {
    private NodeLL<T> head = null;

    public void add(T obj) {
        NodeLL<T> n = new NodeLL<>(obj);
        n.next = head;
        head = n;
    }

    public T remove(T obj) {
        NodeLL<T> n = new NodeLL<>(obj);
        NodeLL<T> pb = head;

        if (head.val == n.val) head = head.next;
        else {
            Iterator<T> it = iterator();
            while (it.hasNext()) {
                NodeLL<T> p = it.next();
                if (p.val == n.val) {
                    pb.next = p.next;
                    return n.val;
                }
                pb = p;
            }
        }

        return null;
    }

    public void print() {
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            NodeLL<T> p = it.next();
            System.out.println(p + " ");
        }
        System.out.print("\n");
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(head);
    }

    private static class ListIterator<T> implements Iterator<T> {
        private NodeLL<T> curr;

        public ListIterator(NodeLL<T> head) {
            this.curr = head;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public NodeLL<T> next() {
            NodeLL<T> n = curr;
            curr = curr.next;
            return n;
        }
    }

}
