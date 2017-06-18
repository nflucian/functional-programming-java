package ro.neghina.java8.stream;

import ro.neghina.java8.model.Dish;
import ro.neghina.java8.model.DishType;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static ro.neghina.java8.model.Dish.menu;

public class Filtering {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);

        System.out.println("---Filtering even & unique numbers---");
        System.out.println(filteringUniqueElements(numbers));

        System.out.println("---Filtering vegetarian dish---");
        filteringVegetarian(menu).forEach(System.out::println);
        System.out.println("---");
        filteringWithPredicate(menu, Dish::isVegetarian).forEach(System.out::println);
        System.out.println("---Filtering MEAT dish---");
        filteringWithPredicate(menu, (d) -> DishType.MEAT.equals(d.getType())).forEach(System.out::println);

        System.out.println("---Truncating a stream---");
        truncating(menu).forEach(System.out::println);

        System.out.println("---Skipping elements---");
        skipping(menu).forEach(System.out::println);

    }

    private static List<Integer> filteringUniqueElements(final List<Integer> numbers) {
        return numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<Dish> filteringWithPredicate(final List<Dish> dishes, Predicate<Dish> predicate) {
        return dishes.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    private static List<Dish> filteringVegetarian(final List<Dish> dishes) {
        return dishes.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
    }

    private static List<Dish> truncating(final List<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
    }

    private static List<Dish> skipping(final List<Dish> dishes) {
        return dishes.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
    }
}
