package oop_abstract.arithmetic_expressions;

public class Multiplication extends BinaryOperation {

    Multiplication(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public String getOperator() {
        return "*";
    }

    @Override
    public int evaluate(Bindings bindings) {
        return getLeft().evaluate(bindings) * getRight().evaluate(bindings);
    }

    @Override
    public Expression reduce() {
        Expression left = getLeft().reduce();
        Expression right = getRight().reduce();
        Multiplication multiplication = new Multiplication(left, right);

        if (multiplication.getLeft() instanceof Literal && multiplication.getRight() instanceof Literal) {
            int valLeft = ((Literal) multiplication.getLeft()).getValue();
            int valRight = ((Literal) multiplication.getRight()).getValue();

            return new Literal(valLeft * valRight);
        } else if (multiplication.getLeft() instanceof Literal) {
            int valLeft = ((Literal) multiplication.getLeft()).getValue();

            if (valLeft == 0) {
                return new Literal(0);
            } else if (valLeft == 1) {
                return multiplication.getRight();
            }
        } else if (multiplication.getRight() instanceof Literal) {
            int valRight = ((Literal) multiplication.getRight()).getValue();

            if (valRight == 0) {
                return new Literal(0);
            } else if (valRight == 1) {
                return multiplication.getLeft();
            }
        }
        return multiplication;
    }
}
