package datastructure.collectors;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CollectorsTest {

    public static void main(String[] args) {

        List<String> givenList = Arrays.asList("a", "bb", "cc", "bb");
        List<String> stringList = givenList.stream().collect(toList());
        Set<String> stringSet = givenList.stream().collect(Collectors.toSet());
        LinkedList<String> stringLinkedList = givenList.stream().collect(Collectors.toCollection(LinkedList::new));
        Map<String, Integer> stringIntegerMap = givenList.stream().collect(
                Collectors.toMap(
                        str -> str,
                        String::length,
                        (oldValue, newValue) -> oldValue
                )
        );
        for (Map.Entry<String, Integer> map : stringIntegerMap.entrySet()) {
            System.out.println("[Key]: " + map.getKey() + ", [Value]: " + map.getValue());
        }

        /**
        System.out.println(givenList.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toList(), Collections::toString
                )
        ));
        */

        String result = givenList.stream().collect(Collectors.joining());
        System.out.println(result);

        String result2 = givenList.stream().collect(
                Collectors.joining(" ", "PRE-", "-POST")
        );
        System.out.println(result2);

        Long result3 = givenList.stream().collect(counting());
        System.out.println(result3);

        Map<Integer, List<String>> result4 = givenList.stream().collect(
                groupingBy(String::length, Collectors.toList())
        );
        System.out.println(result4);
    }
}
