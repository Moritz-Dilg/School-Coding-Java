package recursion;


import java.util.Scanner;

public class Count_x {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");

        String string = scanner.nextLine();
        System.out.println(count_x(string));
    }

    static int count_x(String s) {
        if (s.length() == 1) return s.charAt(0) == 'x' ? 1 : 0;

        return count_x(s.substring(1)) + (s.charAt(0) == 'x' ? 1 : 0);
    }
}
