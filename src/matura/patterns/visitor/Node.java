package matura.patterns.visitor;

public class Node implements VisitorAcceptor {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
