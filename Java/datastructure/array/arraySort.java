package datastructure.array;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.Collections;

public class arraySort {

    public static void main(String[] args) {

        int[] arr = { 3, 6, 2, 1, 9, 10 };

        Arrays.sort(arr);
        Arrays.stream(arr).forEach(elem -> System.out.print(elem + " "));
        System.out.println();

        int[] arr2 = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        Arrays.stream(arr2).forEach(elem -> System.out.print(elem + " "));
    }
}
