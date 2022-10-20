package functional.streams;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT), new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT), new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER), new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER), new Dish("prawns", false, 400, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));


        // Imperative: Low calories (less than 400)
        List<Dish> lowCalories = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() < 400) {
                lowCalories.add(dish);
            }
        }
        lowCalories.sort((a, b) -> Integer.compare(a.getCalories(), b.getCalories()));
        List<String> lowCaloriesNames = new ArrayList<>();
        for (Dish dish : lowCalories) {
            lowCaloriesNames.add(dish.getName());
        }
        System.out.println(lowCaloriesNames);


        // Functional: Low calories (less than 400)
        List<String> names = menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .toList();

        System.out.println(names);
    }
}
