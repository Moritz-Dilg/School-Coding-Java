package designpatterns.visitor.epr;

interface ExprVisitor<T> {
    T visit(Literal literal);

    T visit(Add add);

    T visit(Sub sub);

    T visit(Mul mul);

    T visit(Div div);
}

public class ExprVisitorDemo {
    public static void main(String[] args) {
        Expr expr = new Add(new Literal(4), new Mul(new Literal(3), new Literal(2)));
        System.out.println(expr.accept(new PrintVisitor()));
        System.out.println(expr.accept(new EvalVisitor()));
    }
}

class EvalVisitor implements ExprVisitor<Double> {
    @Override
    public Double visit(Literal literal) {
        return (double) literal.getValue();
    }

    @Override
    public Double visit(Add add) {
        return add.getLeft().accept(this) + add.getRight().accept(this);
    }

    @Override
    public Double visit(Sub sub) {
        return sub.getLeft().accept(this) - sub.getRight().accept(this);
    }

    @Override
    public Double visit(Mul mul) {
        return mul.getLeft().accept(this) * mul.getRight().accept(this);
    }

    @Override
    public Double visit(Div div) {
        return div.getLeft().accept(this) / div.getRight().accept(this);
    }
}

class PrintVisitor implements ExprVisitor<String> {
    @Override
    public String visit(Literal literal) {
        return String.valueOf(literal.getValue());
    }

    @Override
    public String visit(Add add) {
        return "(" + add.getLeft().accept(this) + " + " + add.getRight().accept(this) + ")";
    }

    @Override
    public String visit(Sub sub) {
        return "(" + sub.getLeft().accept(this) + " - " + sub.getRight().accept(this) + ")";
    }

    @Override
    public String visit(Mul mul) {
        return "(" + mul.getLeft().accept(this) + " * " + mul.getRight().accept(this) + ")";
    }

    @Override
    public String visit(Div div) {
        return "(" + div.getLeft().accept(this) + " / " + div.getRight().accept(this) + ")";
    }
}
