package oop_abstract.arithmetic_expressions;

public class Arithmetic {
    public static void main(String[] args) {
        Addition addition = new Addition(new Literal(1), new Literal(0));
        Multiplication m = new Multiplication(new Variable("x"), addition);
        Multiplication n = new Multiplication(new Variable("b"), new Literal(500));
        Addition b = new Addition(m, new Literal(6));
        Addition a = new Addition(n, b);

        Bindings bindings = new Bindings();
        bindings.set("x", 3);
        bindings.set("b", 17);

        System.out.println(a + " -> " + a.reduce());
        System.out.println(a.evaluate(bindings) + " -> " + a.reduce().evaluate(bindings));
    }
}
