package designpatterns.visitor.epr;

public interface Expr {
    public <T> T accept(ExprVisitor<T> visitor);
}

class Literal implements Expr {
    private int value;

    public Literal(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

abstract class BinaryOperation implements Expr {
    private Expr left;
    private Expr right;

    public BinaryOperation(Expr left, Expr right) {
        this.left = left;
        this.right = right;
    }

    public Expr getLeft() {
        return left;
    }

    public Expr getRight() {
        return right;
    }
}

class Add extends BinaryOperation {
    public Add(Expr left, Expr right) {
        super(left, right);
    }

    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Sub extends BinaryOperation {
    public Sub(Expr left, Expr right) {
        super(left, right);
    }


    @Override
    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Mul extends BinaryOperation {
    public Mul(Expr left, Expr right) {
        super(left, right);
    }

    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

class Div extends BinaryOperation {
    public Div(Expr left, Expr right) {
        super(left, right);
    }

    public <T> T accept(ExprVisitor<T> visitor) {
        return visitor.visit(this);
    }
}

