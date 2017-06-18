package ro.neghina.java8.predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonPredicates {

    public static Predicate<Person> isAdultMale() {
        return p -> p.getAge() > 17 && p.getGender().equalsIgnoreCase("M");
    }

    public static Predicate<Person> isAdultFemale() {
        return p -> p.getAge() > 17 && p.getGender().equalsIgnoreCase("F");
    }

    public static Predicate<Person> isAgeMoreThan(final Integer age) {
        return p -> p.getAge() > age;
    }

    public static List<Person> filterPersonsStream(final List<Person> persons, Predicate<Person> filter) {
        return persons.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    public static List<Person> filterPersons(final List<Person> persons, Predicate<Person> predicate) {
        List<Person> result = new ArrayList<>();
        for(Person person : persons) {
            if(predicate.test(person)) {
                result.add(person);
            }
        }

        return result;
    }

}
