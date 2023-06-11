package datastructure.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ArrayListTest {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(1);
        arrayList.add(1, 10);
        System.out.println(arrayList);

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        /**
        list.remove(new Integer(1));
        list.remove(1);
        */
        System.out.println(list.removeIf(e -> e.equals(2)));
        System.out.println(list);

        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("hello", "my", "name"));
        list2.replaceAll(str -> str.toUpperCase());
        System.out.println(list2);

        list2.replaceAll(str -> String.valueOf(str.length()));
        System.out.println(list2);

        ArrayList<Integer> list3 = new ArrayList<Integer>(5);
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(5);
        list3.add(6);
        list3.add(7);
        list3.add(8);
        System.out.println(list3);
        System.out.println(list3.size());

        ArrayList<String> list4 = new ArrayList<>(Arrays.asList("hello", "my"));
        ArrayList<String> list5 = new ArrayList<>(Arrays.asList("hello", "mya", "name"));
        list5.retainAll(list4);
        System.out.println(list5);

        list4.forEach(elem -> System.out.println("elem: " + elem));
        list4.forEach(elem -> System.out.println(elem.toUpperCase()));
    }
}
