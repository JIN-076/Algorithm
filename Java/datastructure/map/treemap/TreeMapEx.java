package datastructure.map.treemap;

import java.util.*;

public class TreeMapEx {

    public static void main(String[] args) {

        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(1, "apple");
        map.put(2, "apples");
        map.put(3, "abcdefsghi");
        map.put(4, "baby");
        map.put(5, "me");
        map.put(6, "abc");

        Iterator<Map.Entry<Integer, String>> entry = map.entrySet().iterator();
        while (entry.hasNext()) {
            System.out.println(entry.next());
        }

        TreeSet<String> set = new TreeSet<>(map.values());
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        Collection<String> valueSet = map.values();
        String[] valueArr = valueSet.stream().sorted().toArray(String[]::new);
        Arrays.stream(valueArr).forEach(elem -> System.out.println(elem));

        System.out.println();

        Set<Integer> keySet = map.keySet();
        int[] keyArr = keySet.stream().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        Arrays.stream(keyArr).forEach(elem -> System.out.println(elem));
    }
}
