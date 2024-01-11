package oop_abstract.arithmetic_expressions;

public class Literal extends Expression {
    private final int value;

    Literal(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int evaluate(Bindings bindings) {
        return getValue();
    }

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }

    @Override
    public Expression reduce() {
        return this;
    }
}
