package oop_abstract.arithmetic_expressions;

public abstract class Expression {
    public abstract int evaluate(Bindings bindings);

    public abstract String toString();

    public abstract Expression reduce();
}
