package oop_abstract.drawing;

import java.awt.*;
import java.util.Scanner;

public class Rectangle extends GraphObject {
    int width;
    int height;

    Rectangle(Point location, int width, int height, Color color) {
        super(location, color);
        this.width = width;
        this.height = height;
    }

    public static Rectangle readRectangle() {
        Point point = Point.readPoint();
        System.out.print("Width and height (w, h): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] pos = input.split(" ");
        return new Rectangle(point, Integer.parseInt(pos[0]), Integer.parseInt(pos[1]), readColor());
    }

    @Override
    public void resize(double scalar) {
        this.width *= scalar;
        this.height *= scalar;
    }

    public void draw() {
        Window.fillRectangle(this.getLocation().x, this.getLocation().y, this.width, this.height, this.getColor());
    }

    public String toString() {
        return "Rectangle " + this.getLocation().asString() + " - " + this.width + " | " + this.height + " - RGB = " + this.getColor().toString();
    }
}
