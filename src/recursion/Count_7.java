package recursion;

import java.util.Scanner;

public class Count_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");

        int number = scanner.nextInt();
        System.out.println(count_7(number));
    }

    static int count_7(int n) {
        if (n / 10 == 0) return n == 7 ? 1 : 0;

        int x = n % 10;
        return count_7(n / 10) + (x == 7 ? 1 : 0);
    }
}
