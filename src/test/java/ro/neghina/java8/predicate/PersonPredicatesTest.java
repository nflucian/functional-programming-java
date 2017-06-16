package ro.neghina.java8.predicate;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static ro.neghina.java8.predicate.PersonPredicates.*;

public class PersonPredicatesTest {

    private List<Person> persons = Arrays.asList(
            new Person("Lucian", "Neghina", 30, "M"),
            new Person("Roxana", "Popescu", 15, "F"),
            new Person("Robert", "Ionescu", 13, "M"),
            new Person("Alex", "Martin", 18, "M"),
            new Person("Cristina", "Dinu", 45, "F"),
            new Person("Doru", "Ionel", 17, "M")
        );

    @Test
    public void onlyAdultMale() {
        List<Person> result = filterPersons(persons, isAdultMale());

        assertEquals("should return only adult male", 2, result.size());
    }

    @Test
    public void onlyAdultFemale() {
        List<Person> result = filterPersons(persons, isAdultFemale());

        assertEquals("should return only adult female", 1, result.size());
    }

    @Test
    public void onlyPersonWithAgeMoreThan() {
        List<Person> result = filterPersons(persons, isAgeMoreThan(30));

        assertEquals("should return the persons older than", 1, result.size());
    }

    @Test
    public void onlyPersonWithAgeLessThan() {
        List<Person> result = filterPersons(persons, isAgeMoreThan(30).negate());

        assertEquals("should return the persons younger than", 5, result.size());
    }
}
