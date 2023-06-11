package datastructure.map.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapEx {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>(){{
            put(1, "apple");
            put(2, "banana");
            put(3, "grape");
        }};

        System.out.println(map.remove(1));
        System.out.println(map.remove(2, "banana"));

        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "hello");
        hashMap.put(2, "world");

        HashMap<Integer, String> hashMap1 = new HashMap<>();
        hashMap1.putAll(hashMap);
        hashMap1.put(-1, "blue");
        hashMap1.put(10, "pink");
        hashMap1.put(-19, "green");

        Set<Integer> set = hashMap1.keySet();
        int[] arr = set.stream().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        Arrays.stream(arr).forEach(elem -> System.out.println(elem));

        Collection<String> valueSet = hashMap1.values();

        Set<Integer> set2 = new HashSet<>();
        set2.addAll(set);
        set2 = set2.stream().sorted(Collections.reverseOrder()).collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> set3 = new HashSet<>();
        set3.addAll(set);
        set3 = set3.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));

        Iterator<Integer> iter = set2.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        String[] valueArr = valueSet.stream().sorted(Collections.reverseOrder()).toArray(String[]::new);
        Integer[] keyArr = set.stream().sorted(Collections.reverseOrder()).toArray(Integer[]::new);

        System.out.println();

        HashSet<Integer> set4 = new HashSet<>(){{
            add(5);
            add(-1);
            add(999);
            add(-91);
        }};
        set4 = set4.stream().sorted(Collections.reverseOrder()).collect(Collectors.toCollection(LinkedHashSet::new));
        set4.stream().forEach(elem -> System.out.println(elem));

        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 4);
        map1.put(2, 9);
        map1.replace(1, 4, 11);
        map1.replace(2, 90);
        System.out.println(map1.get(1));
        System.out.println(map1.get(2));
        map1.put(3, 100);
        map1.putIfAbsent(4, 101);
        System.out.println(map1.get(4));
        System.out.println(map1.putIfAbsent(3, 105));
        if (map1.putIfAbsent(3, 105) == null) System.out.println("null");
        System.out.println(map1.putIfAbsent(6, 100));
    }
}
