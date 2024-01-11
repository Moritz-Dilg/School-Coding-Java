package recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        int x = scanner.nextInt();

        System.out.println(factorial(x));

        //Fact of 0-12
        long[] array = new long[13];
        for (int i = 0; i < 13; i++) {
            array[i] = factorial(i);
        }

        for (int i = 12; i > 0; i--) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[0]);
    }

    static long factorial(int x) {
        if (x == 0) return 1;

        return factorial(x - 1) * x;
    }
}
