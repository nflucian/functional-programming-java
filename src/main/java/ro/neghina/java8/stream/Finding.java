package ro.neghina.java8.stream;

import ro.neghina.java8.model.Dish;
import ro.neghina.java8.model.DishType;

import java.util.Optional;

import static ro.neghina.java8.model.Dish.menu;

public class Finding {

    public static void main(String[] args) {
        if (isVegetarianFriendlyMenu()) {
            System.out.println("Vegetarian friendly");
        }

        System.out.println("--- Healthy menu ---");
        System.out.println(isHealthyMenu());
        System.out.println(isHealthyMenu2());

        System.out.println("--- Vegetarian dish ---");
        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));

        System.out.println("--- First fish dish ---");
        getFirstFishDich().ifPresent(d -> System.out.println(d.getName()));
    }

    private static boolean isVegetarianFriendlyMenu() {
        return menu.stream().anyMatch(Dish::isVegetarian);
    }

    private static boolean isHealthyMenu() {
        return menu.stream().allMatch(d -> d.getCalories() < 1000);
    }

    private static boolean isHealthyMenu2() {
        return menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }

    private static Optional<Dish> findVegetarianDish() {
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }

    private static Optional<Dish> getFirstFishDich() {
        return menu.stream().filter(d -> DishType.FISH.equals(d.getType())).findFirst();
    }
}
