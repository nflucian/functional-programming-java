package ro.neghina.java8.stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
    }

    public static List<String> transformList(final List<String> strings) {
        return strings.stream()
                .map(s -> s.toUpperCase())
                .collect(toList());
    }

    public static List<Integer> transformListOfList(final List<List<Integer>> collection) {
        return collection.stream()
                .flatMap(numbers -> numbers.stream().map(n -> n + 1))
                .collect(toList());
    }
}
