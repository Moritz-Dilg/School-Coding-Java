package oop_abstract.drawing;

import java.awt.*;
import java.util.Scanner;

public class Circle extends GraphObject {
    int radius;

    Circle(Point center, int radius, Color color) {
        super(center, color);
        this.radius = radius;
    }

    public static Circle readCircle() {
        Point point = Point.readPoint();
        System.out.print("Radius (r): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new Circle(point, Integer.parseInt(input), readColor());
    }

    @Override
    public void resize(double scalar) {
        radius *= scalar;
    }

    public void draw() {
        Window.fillCircle(this.getLocation().x, this.getLocation().y, this.radius, this.getColor());
    }

    public String toString() {
        return "Point " + this.getLocation().asString() + " / " + this.radius + " - RGB = " + this.getColor().toString();
    }
}
