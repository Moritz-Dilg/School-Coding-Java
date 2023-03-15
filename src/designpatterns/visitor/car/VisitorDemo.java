package designpatterns.visitor.car;

import java.awt.*;

interface VisitorAcceptor {
    void accept(Visitor visitor);
}

interface Visitor {
    void visit(Car car);

    void visit(Engine engine);

    void visit(Body body);

    void visit(Wheel wheel);
}

class PrintVisitor implements Visitor {
    public void visit(Car car) {
        System.out.println("Visiting car");

        for (Wheel wheel : car.wheels) {
            wheel.accept(this);
        }
        car.engine.accept(this);
        car.body.accept(this);
    }

    public void visit(Engine engine) {
        System.out.println("Visiting engine");
    }

    public void visit(Body body) {
        System.out.println("Visiting body");
    }

    public void visit(Wheel wheel) {
        System.out.println("Visiting " + wheel.getName() + " wheel");
    }
}

class DrawVisitor implements Visitor {
    DrawVisitor() {
        Window.open();
    }

    public void visit(Car car) {
        System.out.println("Drawing car");

        for (Wheel wheel : car.wheels) {
            wheel.accept(this);
        }
        car.body.accept(this);
        car.engine.accept(this);
    }

    public void visit(Engine engine) {
        System.out.println("Drawing engine");
        Window.fillRectangle(112, 102, 16, 16, Color.RED);
    }

    public void visit(Body body) {
        System.out.println("Drawing body");
        Window.fillRectangle(70, 85, 30, 15, Color.BLACK);
        Window.fillRectangle(50, 100, 80, 20, Color.BLACK);
    }

    public void visit(Wheel wheel) {
        System.out.println("Drawing " + wheel.getName() + " wheel");
        if (wheel.getName().contains("front")) Window.fillCircle(120, 130, 10, Color.BLACK);
        else Window.fillCircle(60, 130, 10, Color.BLACK);
    }
}

public class VisitorDemo {
    static public void main(String[] args) {
        Car car = new Car();

        Visitor printVisitor = new PrintVisitor();
        car.accept(printVisitor);

        Visitor drawVisitor = new DrawVisitor();
        car.accept(drawVisitor);
    }
}
