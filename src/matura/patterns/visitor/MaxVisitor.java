package matura.patterns.visitor;

public class MaxVisitor implements Visitor {
    @Override
    public int visit(Node node) {
        int max = node.val;
        if (node.left != null) max = Math.max(max, visit(node.left));
        if (node.right != null) max = Math.max(max, visit(node.right));

        return max;
    }
}
