package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Arrays_2 {

    private static void bsp6() {
        String[] sa = {"TINF", "ist", "mein", "Lieblingsfach"};

        int max_length = 0;
        for (String s : sa) {
            max_length = s.length();
        }

        for (String s : sa) {
            System.out.print(s.indent(max_length - s.length()));
        }
    }


    private static void bsp5() {
        ArrayList<circle> circleArrayList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            circleArrayList.add(new circle(new Random().nextInt(0, 50),
                    new Random().nextInt(0, 50),
                    new Random().nextInt(0, 30)));
        }

        for (int i = 0; i < 7; i++) {
            circle circle = circleArrayList.get(i);
            System.out.println("Pos X: " + circle.pos_x + ", Pos Y: " + circle.pos_y + ", Radius: " + circle.radius);
            System.out.println(circle.isHit(20, 20) ? "Point (20|20) is inside the rectangle\n" : "Point (20|20) is not inside the rectangle\n");
        }
    }

    private static class circle {
        int pos_x, pos_y;
        int radius;

        public circle(int pos_x, int pos_y, int radius) {
            this.pos_x = pos_x;
            this.pos_y = pos_y;
            this.radius = radius;
        }

        public boolean isHit(int x, int y) {
            return Math.sqrt(Math.pow(x - this.pos_x, 2) + Math.pow(y - this.pos_y, 2)) <= this.radius;
        }
    }


    private static int[] bsp4(int stones, int n_worker) {
        int[] worker = new int[n_worker];
        int x = stones / n_worker;
        java.util.Arrays.fill(worker, x);

        for (int i = 0; i < stones % n_worker && i < worker.length; i++) {
            worker[i]++;
        }

        return worker;
    }


    private static int[] bsp3(int x) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= x; i++) {
            while (x % i == 0) {
                factors.add(i);
                x /= i;
            }
        }

        int[] arr = new int[factors.size()];
        for (int i = 0; i < factors.size(); i++)
            arr[i] = factors.get(i);

        return arr;
    }


    private static void bsp2() {
        ArrayList<rectangle> rectangleArrayList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            rectangleArrayList.add(new rectangle(new Random().nextInt(0, 50),
                    new Random().nextInt(0, 50),
                    new Random().nextInt(0, 50),
                    new Random().nextInt(0, 50)));
        }

        for (int i = 0; i < 7; i++) {
            rectangle rectangle = rectangleArrayList.get(i);
            System.out.println("Pos X: " + rectangle.pos_x + ", Pos Y: " + rectangle.pos_y + ", Size X: " + rectangle.size_x + ", Size Y: " + rectangle.size_y);
            System.out.println(rectangle.isHit(20, 20) ? "Point (20|20) is inside the rectangle\n" : "Point (20|20) is not inside the rectangle\n");
        }
    }

    private static class rectangle {
        int pos_x, pos_y;
        int size_x, size_y;

        public rectangle(int pos_x, int pos_y, int size_x, int size_y) {
            this.pos_x = pos_x;
            this.pos_y = pos_y;
            this.size_x = size_x;
            this.size_y = size_y;
        }

        public boolean isHit(int x, int y) {
            return x >= this.pos_x && x <= this.pos_x + this.size_x &&
                    y >= this.pos_y && y <= this.pos_y + this.size_y;
        }
    }


    private static int[] bsp1(int length) {
        int[] array = new int[length];
        array[0] = 1;
        array[1] = 2;

        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] * array[i - 2];
        }

        return array;
    }

}
