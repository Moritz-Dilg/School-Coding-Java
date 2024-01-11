package oop_abstract.arithmetic_expressions;

public class Variable extends Expression {
    private final String name;

    Variable(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int evaluate(Bindings bindings) {
        return bindings.get(getName());
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public Expression reduce() {
        return this;
    }
}
