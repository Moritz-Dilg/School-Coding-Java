package oop_abstract.arithmetic_expressions;

public class Addition extends BinaryOperation {

    Addition(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String getOperator() {
        return "+";
    }

    @Override
    public int evaluate(Bindings bindings) {
        return getLeft().evaluate(bindings) + getRight().evaluate(bindings);
    }

    @Override
    public Expression reduce() {
        Expression left = getLeft().reduce();
        Expression right = getRight().reduce();
        Addition addition = new Addition(left, right);


        if (addition.getLeft() instanceof Literal && addition.getRight() instanceof Literal) {
            int valLeft = ((Literal) addition.getLeft()).getValue();
            int valRight = ((Literal) addition.getRight()).getValue();

            return new Literal(valLeft + valRight);
        } else if (addition.getLeft() instanceof Literal) {
            int valLeft = ((Literal) addition.getLeft()).getValue();

            if (valLeft == 0) {
                return addition.getRight();
            }
        } else if (addition.getRight() instanceof Literal) {
            int valRight = ((Literal) addition.getRight()).getValue();

            if (valRight == 0) {
                return addition.getLeft();
            }
        }
        return addition;
    }
}
