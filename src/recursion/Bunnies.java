package recursion;

import java.util.Scanner;

public class Bunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number: ");

        int number = scanner.nextInt();
        System.out.println(bunnyEars(number));
    }

    static int bunnyEars(int n) {
        if (n <= 0) return 0;

        return n % 2 != 0 ? bunnyEars(n - 1) + 2 : bunnyEars(n - 1) + 3;
    }
}
