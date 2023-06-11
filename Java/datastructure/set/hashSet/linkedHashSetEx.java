package datastructure.set.hashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class linkedHashSetEx {

    public static void main(String[] args) {

        HashSet<Integer> set = new LinkedHashSet<>(Arrays.asList(6, 3, 1, 9, 9));
        System.out.println(set.size());
        set.stream().forEach(elem -> System.out.println("값::: " + elem));
    }
}
