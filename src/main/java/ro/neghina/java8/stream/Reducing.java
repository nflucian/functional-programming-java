package ro.neghina.java8.stream;

import ro.neghina.java8.model.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.reducing;
import static ro.neghina.java8.model.Dish.menu;

public class Reducing {

    public static void main(String...args){
        System.out.println("Sum of numbers: " + getSum(Arrays.asList(1,2,3,4,5)));

        System.out.println("Total calories in menu: " + getMenuCalories(menu));
        System.out.println("Total calories in menu: " + calculateTotalCalories());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesWithMethodReference());
        System.out.println("Total calories in menu: " + calculateTotalCaloriesUsingSum());
    }

    private static Integer getSum(final List<Integer> numbers) {
        return numbers.stream().reduce(0, (a,b) -> a + b);
    }

    private static Integer getMenuCalories(final List<Dish> menu) {
        return menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
    }

    private static int calculateTotalCalories() {
        return menu.stream()
                .collect(reducing(0, Dish::getCalories, (Integer i, Integer j) -> i + j));
    }

    private static int calculateTotalCaloriesWithMethodReference() {
        return menu.stream()
                .collect(reducing(0, Dish::getCalories, Integer::sum));
    }

    private static int calculateTotalCaloriesUsingSum() {
        return menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
    }

}
