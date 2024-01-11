package recursion;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");

        int n = scanner.nextInt();
        System.out.println(triangle(n));
    }

    static int triangle(int n) {
        if (n == 0) return 0;

        return triangle(n - 1) + n;
    }
}
