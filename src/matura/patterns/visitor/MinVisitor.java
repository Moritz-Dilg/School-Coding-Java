package matura.patterns.visitor;

public class MinVisitor implements Visitor {
    @Override
    public int visit(Node node) {
        int min = node.val;
        if (node.left != null) min = Math.min(min, visit(node.left));
        if (node.right != null) min = Math.min(min, visit(node.right));

        return min;
    }
}
