package ro.neghina.java8.stream;

import ro.neghina.java8.model.Dish;
import ro.neghina.java8.model.DishType;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static ro.neghina.java8.model.Dish.menu;

public class Transformation {

    public static void main(String[] args) {
        List<String> streamMap = transformList(Arrays.asList("a", "b", "hello"));
        assert (Arrays.asList("A", "B", "HELLO").equals(streamMap));

        System.out.println(streamMap);

        List<Integer> l1 = Arrays.asList(1, 2);
        List<Integer> l2 = Arrays.asList(3, 4);
        List<Integer> streamFlatMap = transformListOfList(Arrays.asList(l1, l2));
        assert (Arrays.asList(2, 3, 4, 5).equals(streamFlatMap));

        System.out.println(streamFlatMap);

        System.out.println("---Dishes name---");
        System.out.println(transformDishes(menu, Dish::getName));

        System.out.println("---Dishes name & calories---");
        System.out.println(transformDishes(menu, d -> d.getName().toUpperCase()+":"+d.getCalories()));
    }

    private static List<String> transformList(final List<String> strings) {
        return strings.stream()
                .map(s -> s.toUpperCase())
                .collect(toList());
    }

    private static List<Integer> transformListOfList(final List<List<Integer>> collection) {
        return collection.stream()
                .flatMap(numbers -> numbers.stream().map(n -> n + 1))
                .collect(toList());
    }

    private static List<String> transformDishes(final List<Dish> dishes, final Function<Dish, String> mapping) {
        return dishes.stream()
                .map(mapping)
                .collect(toList());
    }
}
