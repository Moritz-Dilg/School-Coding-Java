package oop_abstract.drawing;

import java.awt.*;

public class Line extends GraphObject {
    Point to;

    Line(Point from, Point to, Color color) {
        super(from, color);
        this.to = to;
    }

    public static Line readLine() {
        return new Line(Point.readPoint(), Point.readPoint(), readColor());
    }

    @Override
    public void resize(double scalar) {
        this.to.x *= scalar;
        this.to.y *= scalar;
    }

    public void draw() {
        to.draw();
        getLocation().draw();
        Window.drawLine(this.getLocation().x, this.getLocation().y, this.to.x, this.to.y);
    }

    public String toString() {
        return "Point " + this.getLocation().asString() + " - " + this.to.toString() + " - RGB = " + this.getColor().toString();
    }
}
