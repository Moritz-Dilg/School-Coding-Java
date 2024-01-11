package interfaces.list;

public class Node implements Comparable<Node> {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }

    @Override
    public int compareTo(Node o) {
        return o.val - this.val;
    }
}
