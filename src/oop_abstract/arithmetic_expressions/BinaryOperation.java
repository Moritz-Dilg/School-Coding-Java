package oop_abstract.arithmetic_expressions;

public abstract class BinaryOperation extends Expression {
    private final Expression left;
    private final Expression right;

    BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return this.left;
    }

    public Expression getRight() {
        return this.right;
    }

    public abstract String getOperator();

    @Override
    public String toString() {
        return "(" + getLeft().toString() + " " + getOperator() + " " + getRight().toString() + ")";
    }
}
