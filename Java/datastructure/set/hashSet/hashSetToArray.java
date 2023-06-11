package datastructure.set.hashSet;

import java.util.Arrays;
import java.util.HashSet;

public class hashSetToArray {

    public static void printArr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        HashSet<Integer> set =  new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));

        int[] arr = set.stream().mapToInt(i -> i).toArray();
        printArr(arr);

        Integer[] arr2 = set.toArray(new Integer[0]);
        System.out.println(arr2[0]);
    }
}
