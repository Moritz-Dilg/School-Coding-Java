package matura.patterns.visitor;

public class SumVisitor implements Visitor {
    @Override
    public int visit(Node node) {
        int sum = node.val;
        if (node.left != null) sum += visit(node.left);
        if (node.right != null) sum += visit(node.right);

        return sum;
    }
}
