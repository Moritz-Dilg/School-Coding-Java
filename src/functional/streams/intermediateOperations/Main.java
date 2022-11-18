package functional.streams.intermediateOperations;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("---Map---");
        Stream.of("Ann", "Pat", "Mary", "Paul")
                .map(a -> a.substring(0, 1))
                .forEach(System.out::println);


        System.out.println("---FlatMap---");
        Stream.of("Ann", "Pat", "Mary", "Paul")
                .flatMapToInt(a -> a.chars())
                .forEach(a -> System.out.println((char) a));


        System.out.println("---Fibonacci---");
        Stream.iterate(new int[]{1, 1}, a -> new int[]{a[1], a[0] + a[1]})
                .limit(10)
                .forEach(a -> System.out.println(a[0]));

        System.out.println("---Filter---");
        Stream.of("Ann", "Pat", "Mary", "Paul")
                .filter(a -> a.length() > 3)
                .forEach(System.out::println);
    }
}
