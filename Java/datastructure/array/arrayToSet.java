package datastructure.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class arrayToSet {

    public static void main(String[] args) {

        int[] arr = { 1, 1, 2, 3, 4 };
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        HashSet<Integer> hashSet = (HashSet<Integer>) Arrays.stream(arr).boxed().collect(Collectors.toSet());

        System.out.println(set.size());
        System.out.println(hashSet.size());
    }
}
