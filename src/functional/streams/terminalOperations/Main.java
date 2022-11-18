package functional.streams.terminalOperations;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int r = Stream.of(10, 9, 8, 7, 6, 6, 7, 8, 9, 10)
                .reduce(0, (partialSum, x) -> partialSum + x, (partialSum1, partialSum2) -> partialSum1 + partialSum2);
        System.out.println(r);

        int max = Stream.of(10, 9, 8, 7, 6, 6, 7, 8, 9, 10)
                .reduce(Integer.MIN_VALUE, (partialMax, x) -> Integer.max(partialMax, x), (partialMax1, partialMax2) -> Integer.max(partialMax1, partialMax2));
        System.out.println(max);

        int s = Stream.of("Ann", "Pat", "Mary", "Paul")
                .reduce(0, (partialSum, x) -> partialSum + x.length(), (partialSum1, partialSum2) -> partialSum1 + partialSum2);
        System.out.println(s);
    }
}
