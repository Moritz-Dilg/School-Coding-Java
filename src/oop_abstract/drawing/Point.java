package oop_abstract.drawing;

import java.awt.*;
import java.util.Scanner;

public class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        Window.fillRectangle(this.x - 2, this.y - 2, 5, 5, Color.black);
    }

    public static Point readPoint() {
        System.out.print("Point (x, y): ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("-1 -1")) {
            return null;
        }
        String[] pos = input.split(" ");
        return new Point(Integer.parseInt(pos[0]), Integer.parseInt(pos[1]));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String asString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public String toString() {
        return "Point (" + this.x + ", " + this.y + ")";
    }
}
