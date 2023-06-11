package datastructure.set.hashSet;

import java.util.*;

public class hashSetEx {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(325, 43, 89));

        System.out.println(set.size());

        System.out.println(set.contains(2));
        System.out.println(set.contains(4));
        System.out.println(set.contains(8));

        set.remove(2);
        System.out.println(set.contains(2));
        System.out.println(set.size());

        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        Integer max = Collections.max(set);
        Integer min = Collections.min(set);
        System.out.println(max + ", " + min);

        int intMax = Collections.max(set);
        int intMin = Collections.min(set);
        System.out.println(intMax + ", " + intMin);

        int MAX = set.stream().mapToInt(i -> i).max().getAsInt();
        int MIN = set.stream().mapToInt(i -> i).min().getAsInt();
        System.out.println(MAX + ", " + MIN);

        int Max = set.stream().max(Integer::compare).orElse(-1);
        int Min = set.stream().min(Integer::compare).orElse(-1);
        System.out.println(Max + ", " + Min);

        int[] sortedArr = set.stream().mapToInt(i -> i).sorted().toArray();
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.print(sortedArr[i] + " ");
        }
        System.out.println();

        HashSet<Integer> mySet = new HashSet<>(Arrays.asList(8, 2, 9, 10, 5, -1));
        ArrayList<Integer> list = new ArrayList<>(mySet);
        Collections.sort(list);
        Collections.sort(list, Collections.reverseOrder());

        Integer[] arr = set.toArray(new Integer[0]);
        Arrays.sort(arr, Collections.reverseOrder());
        Arrays.stream(arr).forEach(elem -> System.out.print(elem + " "));

        System.out.println();

        int[] arr2 = set.stream().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
        Arrays.stream(arr2).forEach(elem -> System.out.print(elem + " "));

        System.out.println();

        TreeSet<Integer> myTreeSet = new TreeSet<>();
        myTreeSet.addAll(mySet);

        myTreeSet.stream().forEach(elem -> System.out.print(elem + " "));
    }
}
