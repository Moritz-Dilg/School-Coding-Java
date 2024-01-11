package oop_abstract.drawing;

import java.awt.*;
import java.util.ArrayList;

public class Polyline extends Line {
    Point[] points;
    int pointCount;

    Polyline(Point[] points, Color color) {
        super(points[0], points[points.length - 1], color);
        this.points = points;
        this.pointCount = points.length;
    }

    public static Polyline readPolyline() {
        ArrayList<Point> points = new ArrayList<>();
        Point currentPoint = Point.readPoint();
        while (currentPoint != null) {
            points.add(currentPoint);
            currentPoint = Point.readPoint();
        }
        return new Polyline(points.toArray(new Point[0]), readColor());
    }

    public void draw() {
        for (int i = 0; i < this.pointCount - 1; i++) {
            this.points[i].draw();
            Window.drawLine(this.points[i].x, this.points[i].y, this.points[i + 1].x, this.points[i + 1].y);
        }
        this.points[this.pointCount].draw();
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Point point : points) {
            string.append("\n\t").append(point.toString());
        }
        return "Polyline {" + string + "\n}";
    }
}
