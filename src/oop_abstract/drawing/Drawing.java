package oop_abstract.drawing;

import java.util.ArrayList;
import java.util.Scanner;

public class Drawing {
    public static void main(String[] args) {
        Window.open();
        Scanner scanner = new Scanner(System.in);
        String input;

        ArrayList<GraphObject> graphObjects = new ArrayList<>();


        while (true) {
            System.out.print("Figure (L|R|C|P|.): ");
            input = scanner.nextLine();
            if (input.equals(".")) break;
            GraphObject currentGraphObject = switch (input) {
                case "P" -> Polyline.readPolyline();
                case "L" -> Line.readLine();
                case "R" -> Rectangle.readRectangle();
                case "C" -> Circle.readCircle();
                default -> throw new IllegalStateException("Unexpected value: " + input);
            };
            currentGraphObject.draw();
            graphObjects.add(currentGraphObject);
        }

        System.out.println("\n");

        for (GraphObject graphObject : graphObjects) {
            System.out.println(graphObject.toString());
        }
    }
}
