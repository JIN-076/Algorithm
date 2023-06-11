package datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayTest {

    public static void main(String[] args) {

        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        System.out.println(arr.length);

        List<Integer> list = new ArrayList<>();
        for (int elem : arr) {
            list.add(elem);
        }

        System.out.println(list.contains(5));

        /**
         * Collectors -> Stream을 일반적인 List, Set 등으로 변환하는 Stream 메서드
         * toList, toSet, toCollection, toMap
         * collectingAndThen, joining, counting, groupingBy
         */

        List<Integer> list1 = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list1.contains(3));

        /**
         * boolean anyMatch(Predicate<? super T> predicate)
         * Stream 하나라도 조건을 만족하는지 확인. 하나라도 만족 시 true 반환. 빈 스트림일 시 false 반환
         * true를 반환하는 경우 더 이상 anyMatch()를 호출하지 않음 -> isThirtyExist 참고
         */

        List<Integer> intList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        boolean isThirty = intList.stream().anyMatch(num -> num > 30);
        System.out.println(isThirty);

        boolean isThirtyExist = intList.stream().anyMatch(num -> {
            System.out.println("현재 요소는 : " + num);
            return num > 30;
        });
        System.out.println("30보다 큰 요소가 존재하는가? " + isThirtyExist);

        List<String> strList = new ArrayList<>(Arrays.asList("abc", "Abc"));
        boolean isUpper = strList.stream()
                .anyMatch(strValue -> Character.isUpperCase(strValue.charAt(0)));
        System.out.println("첫 글자가 대문자인 문자열이 존재하는가? " + isUpper);

        boolean isExist = Arrays.stream(arr).anyMatch(num -> num == 3);
        System.out.println(isExist);

        String[] strArr = {"BC", "AC", "CD", "BCD", "CDEF"};
        boolean isStrExist = Arrays.stream(strArr).anyMatch("BC"::equals);
        System.out.println(isStrExist);

        System.out.println("before sort: " + Arrays.toString(strArr));
        Arrays.parallelSort(strArr);
        System.out.println("after sort: " + Arrays.toString(strArr));
        int findIdx = Arrays.binarySearch(strArr, "BCD");
        if (findIdx > 0) {
            System.out.println("true");
        }

        String[] strArr2 = {"AB", "BC", "BCD", "BCD", "CDEF"};
        List<String> stringList = new ArrayList<>(Arrays.asList(strArr2));
        if (stringList.containsAll(Arrays.asList("AB", "CDEF"))) {
            System.out.println("true");
        }

        String[] arr2 = Arrays.copyOf(strArr, strArr.length);
        for (String elem : arr2) {
            System.out.println(elem);
        }
        System.out.println();
        String[] arr3 = Arrays.copyOfRange(strArr, 1, 3); // from ~ to - 1
        for (String elem : arr3) {
            System.out.println(elem);
        }
        System.out.println();
        String[] strArr3 = {"CD", "DE", "DEFG", "AB", "HI"};
        Arrays.sort(strArr3);
        for (String elem : strArr3) {
            System.out.println(elem);
        }
        System.out.println();
        int idx = Arrays.binarySearch(strArr3, "AB");
    }
}