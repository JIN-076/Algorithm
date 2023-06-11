package datastructure.list;

import datastructure.linkedllist.LinkedListTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class arrayToList {

    public static void printintArr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printIntArr(Integer[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printInteger(List<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void printString(List<String> list) {

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] intArr = { 1, 2, 3, 4, 5 };
        List<Integer> list = Arrays.stream(intArr).boxed().collect(Collectors.toList());
        ArrayList<Integer> arrayList = (ArrayList<Integer>) Arrays.stream(intArr).boxed().collect(Collectors.toList());

        printInteger(list);
        printInteger(arrayList);

        list.set(0, 10);
        printInteger(list);
        printintArr(intArr);

        Integer[] integerArr = { 5, 4, 3, 2, 1 };
        List<Integer> integerList = Arrays.stream(integerArr).collect(Collectors.toList());
        ArrayList<Integer> integerArrayList = (ArrayList<Integer>) Arrays.stream(integerArr).collect(Collectors.toList());

        printInteger(integerList);
        printInteger(integerArrayList);

        List<Integer> integerList2 = Arrays.asList(integerArr);
        printInteger(integerList2);
        integerList2.set(0, 10);
        printInteger(integerList2);
        printIntArr(integerArr);

        ArrayList<Integer> integerList3 = new ArrayList<>(Arrays.asList(integerArr));
        printInteger(integerList3);

        String[] strArr = { "Hello", "World", "String" };
        List<String> strList = Arrays.stream(strArr).collect(Collectors.toList());
        ArrayList<String> strArrList = (ArrayList<String>) Arrays.stream(strArr).collect(Collectors.toList());

        printString(strList);
        printString(strArrList);

        List<String> stringList = Arrays.asList(strArr);
        printString(stringList);
    }
}
