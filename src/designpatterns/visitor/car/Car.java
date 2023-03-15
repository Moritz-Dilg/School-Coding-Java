package designpatterns.visitor.car;


class Wheel implements VisitorAcceptor {
    private String name;

    Wheel(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Engine implements VisitorAcceptor {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Body implements VisitorAcceptor {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

public class Car implements VisitorAcceptor {
    Engine engine = new Engine();
    Body body = new Body();
    Wheel[] wheels
            = {new Wheel("front left"), new Wheel("front right"),
            new Wheel("back left"), new Wheel("back right")};

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
