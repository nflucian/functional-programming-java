package ro.neghina.java8.predicate;

import java.util.Arrays;
import java.util.List;

import static ro.neghina.java8.predicate.PersonPredicates.*;

public class Predicate {
    public static final List<Person> persons = Arrays.asList(
            new Person("Lucian", "Neghina", 30, "M"),
            new Person("Roxana", "Popescu", 15, "F"),
            new Person("Robert", "Ionescu", 13, "M"),
            new Person("Alex", "Martin", 18, "M"),
            new Person("Cristina", "Dinu", 45, "F"),
            new Person("Doru", "Ionel", 17, "M")
    );

    public static void main(String[] args) {
        System.out.println("Adult males");
        System.out.println(filterPersons(persons, isAdultMale()));

        System.out.println("Adult females");
        System.out.println(filterPersons(persons, isAdultFemale()));

        System.out.println("Persons older than 25 years");
        System.out.println(filterPersons(persons, isAgeMoreThan(25)));
    }
}
