package designpatterns.composite.drawingApp;


import java.awt.*;
import java.util.ArrayList;

public class AwesomeDrawingApp {

    private final Shape s;

    AwesomeDrawingApp(Shape s) {
        this.s = s;
        Window.open();
    }

    private void show() {
        s.draw();
    }

    public static void main(String[] args) {
        Snowman s = new Snowman(100, 100);
        AwesomeDrawingApp app = new AwesomeDrawingApp(s);
        app.show();
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            s.move(100, 100);

        }).start();
    }
}

class Snowman extends Shape {
    private ArrayList<Shape> shapes = new ArrayList<>();

    Snowman(int x, int y) {
        super(0, 0);
        shapes.add(new Circle(x, y, 30));
        shapes.add(new Circle(x, y + 70, 40));
        shapes.add(new Circle(x, y + 160, 50));
    }

    @Override
    public void draw() {
        for (Shape s : shapes) {
            s.draw();
        }
    }

    @Override
    public void delete() {
        for (Shape s : shapes) {
            s.delete();
        }
    }

    public void move(int dx, int dy) {
        for (Shape s : shapes) {
            s.move(dx, dy);
        }
    }
}

abstract class Shape {
    private int x;
    private int y;


    protected Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void move(int dx, int dy) {
        delete();
        x += dx;
        y += dy;
        draw();
    }

    public abstract void draw();

    public abstract void delete();
}


class Circle extends Shape {
    private final int r;


    Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }


    @Override
    public void draw() {
        Window.drawCircle(getX(), getY(), r);
    }

    @Override
    public void delete() {
        Window.drawCircle(getX(), getY(), r, Color.WHITE);
    }
}

class Rectangle extends Shape {
    private final int w, h;

    Rectangle(int x, int y, int w, int h) {
        super(x, y);
        this.w = w;
        this.h = h;
    }


    @Override
    public void draw() {
        Window.drawRectangle(getX(), getY(), w, h);
    }

    @Override
    public void delete() {
        Window.drawRectangle(getX(), getY(), w, h, Color.WHITE);
    }
}
