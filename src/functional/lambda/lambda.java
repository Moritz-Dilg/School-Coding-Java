package functional.lambda;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;

public class lambda {
    public static void main(String[] args) {
        Function2 add = Integer::sum;
        Function2 sub = new Function2() {
            @Override
            public int eval(int a, int b) {
                return a - b;
            }
        };
        Function2 mul = (a, b) -> a * b;

        printResult((a, b) -> a / b, 10, 5);

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(map((a) -> a * a, arr)));
        System.out.println(Arrays.toString(filter((a) -> a % 2 != 0, arr)));
    }

    public static void printResult(Function2 f, int a, int b) {
        System.out.println(f.eval(a, b));
    }

    public static int[] map(Function<Integer, Integer> f, int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = f.apply(arr[i]);
        }
        return result;
    }

    public static int[] filter(Predicate<Integer> p, int[] arr) {
        int[] result = new int[arr.length];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (p.test(arr[i])) {
                result[idx++] = arr[i];
            }
        }

        return Arrays.copyOf(result, idx);
    }
}
