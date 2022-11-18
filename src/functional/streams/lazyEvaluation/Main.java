package functional.streams.lazyEvaluation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> twoEvenSquares = numbers.stream()
                .filter(n -> {
                    System.out.println("Filtering " + n);
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.println("Mapping " + n);
                    return n * n;
                })
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(twoEvenSquares);
    }

}
