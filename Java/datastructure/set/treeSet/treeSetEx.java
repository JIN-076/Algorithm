package datastructure.set.treeSet;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeSet;

public class treeSetEx {

    public static void printArrRef(Integer[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        TreeSet<Integer> set = new TreeSet<>(Arrays.asList(5, 2, 3, 9, 9, 1));
        System.out.println(set.size());
        set.stream().forEach(elem -> System.out.println("값::: " + elem));

        System.out.println(set.first());
        System.out.println(set.last());

        int[] arr = set.stream().mapToInt(i -> i).toArray();
        printArr(arr);

        Integer[] arr2 = set.stream().toArray(Integer[]::new);
        printArrRef(arr2);

        Integer[] arr3 = set.toArray(new Integer[set.size()]);
        printArrRef(arr3);

        Arrays.sort(arr3, Collections.reverseOrder());
        printArrRef(arr3);

        Arrays.sort(arr);

        Integer[] arr4 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr4, Collections.reverseOrder());
        printArrRef(arr4);

        int[] arr5 = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder())
                .mapToInt(i -> i).toArray();
        printArr(arr5);

        int[] arr6 = Arrays.stream(arr).boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        printArr(arr6);

        int[] arr7 = set.stream().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        Arrays.stream(arr7).forEach(elem -> System.out.print(elem + " "));
        System.out.println();
    }
}
