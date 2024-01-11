package oop_abstract.drawing;

import java.awt.*;
import java.util.Scanner;

public abstract class GraphObject {
    private Color color;
    private Point location;

    public GraphObject(Point location, Color color) {
        this.location = location;
        this.color = color;
    }

    public static Color readColor() {
        System.out.print("Color (R,G,B): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] rgb = input.split(" ");
        return new Color(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
    }

    public Color getColor() {
        return this.color;
    }

    public Point getLocation() {
        return this.location;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public abstract void resize(double scalar);

    public abstract void draw();

    public String toString() {
        return this.location.toString() + " - RGB = " + this.color.toString();
    }
}
