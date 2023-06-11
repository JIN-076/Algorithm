package datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class listToArray {

    public static void printIntArr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printIntegerArr(Integer[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(2, 4, 8)
        );

        Integer[] arr2 = list.toArray(new Integer[list.size()]);
        printIntegerArr(arr2);

        Integer[] arr3 = list.toArray(new Integer[0]);
        printIntegerArr(arr3);

        int[] arr4 = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr4[i] = list.get(i).intValue();
        }
        printIntArr(arr4);

        int[] arr5 = list.stream().mapToInt(i -> i).toArray();
        printIntArr(arr5);

        int[] arr6 = list.stream().mapToInt(Integer::intValue).toArray();
        printIntArr(arr6);

        int[] arr7 = list.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
        printIntArr(arr7);
    }
}
