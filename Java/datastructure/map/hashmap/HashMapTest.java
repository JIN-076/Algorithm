package datastructure.map.hashmap;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class HashMapTest {

    public static LinkedHashMap<String, String> sortMapByKey(Map<String, String> map) {
        List<Map.Entry<String, String>> entries1 = new LinkedList<>(map.entrySet());
        Collections.sort(entries1, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : entries1) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    public static LinkedHashMap<String, String> sortMapByValue(Map<String, String> map) {
        List<Map.Entry<String, String>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : entries) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    public static void main(String[] args) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("apple", "사과");
        hashMap.put("banana", "바나나");
        hashMap.put("soccer", "축구");
        hashMap.put("baseball", "야구");

        /**
         * V put(K key, V value);
         * HashMap에 Key와 Value를 추가하는 메서드
         * key가 이미 존재하는 경우, 매핑되는 값이 변경됨
         */

        System.out.println(hashMap.get("apple"));
        System.out.println(hashMap.getOrDefault("basketball", "empty"));
        System.out.println(hashMap.isEmpty());
        System.out.println(hashMap.size());

        HashMap<String, String> hashMap1 = new HashMap<>();
        hashMap1.put("basketball", "농구");
        hashMap1.put("grape", "포도");

        hashMap.putAll(hashMap1);
        System.out.println(hashMap.getOrDefault("basketball", "empty"));
        System.out.println(hashMap1.size());

        hashMap.remove("apple");
        hashMap.remove("soccer", "축구");

        /**
         * V replace(K key, V value)
         * 특정 key에 해당하는 value을 변경하는 메서드
         * @param K key -> 변경하고자 하는 특정 key
         * @param V value -> 변경하고 싶은 value
         */

        hashMap.replace("banana", "원숭이");
        System.out.println(hashMap.get("banana"));
        hashMap.replace("grape", "포도", "보라색포도");
        System.out.println(hashMap.get("grape"));

        /**
         * void replaceAll(BiFunc<? super K, ? super V, ? extends V> func)
         * 특정 조건을 만족하는 모든 값을 변경할 수 있음
         * 키에 특정 문자열이 포함되는 값만 변경하고 싶을 때
         * 특정 범위에 속하는 값만 변경하고 싶을 떄
         */

        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("React", "리액트");
        hashMap2.put("Java", "자바");
        hashMap2.put("JavaScript", "자바스크립트");
        hashMap2.put("TypeScript", "타입스크립트");

        hashMap2.replaceAll((key, value) -> {
            if (key.contains("Script")) {
                return value + "hate";
            }
            return value;
        });

        for (Map.Entry<String, String> entry : hashMap2.entrySet()) {
            System.out.println("[Key]: " + entry.getKey() + ", [Value]: " + entry.getValue());
        }
        System.out.println();

        for (String key : hashMap.keySet()) {
            String value = hashMap.get(key);
            System.out.println("[Key]: " + key + ", [Value]: " + value);
        }
        System.out.println();

        Iterator<Map.Entry<String, String>> iterator = hashMap2.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("[Key]: " + key + ", [Value]: " + value);
        }

        hashMap.forEach((key, value) -> {
            System.out.println("[Key]: " + key + ", [Value]: " + value);
        });

        hashMap1.entrySet().stream().forEach(entry -> {
            System.out.println("[Key]: " + entry.getKey() + ", [Value]: " + entry.getValue());
        });

        Collection<String> values = hashMap1.values();
        System.out.println(values);

        hashMap1.putIfAbsent("Kiwi", "키위");
        System.out.println(hashMap1.putIfAbsent("Orange", "오렌지")); // 새로운 값 입력 시, null 반환
        System.out.println(hashMap1.get("Kiwi"));

        HashMap<String, Integer> hashMap3 = new HashMap<>();
        hashMap3.put("A", 1);
        System.out.println(hashMap3.compute("A", (s, integer) -> integer + 1));
        System.out.println(hashMap3);

        /**
         * V computeIfAbsent(K key, BiFunction<? super K, ? super V, ? extend V> remappingFunction
         * 기본적으로 compute와 동일함
         * key의 value가 없을 경우에만 func 실행됨 -> func: lambda
         */

        hashMap3.computeIfAbsent("C", key -> 10);
        hashMap3.computeIfAbsent("D", key -> 10);
        hashMap3.computeIfAbsent("G", key -> 25);
        System.out.println(hashMap3.get("C"));
        System.out.println(hashMap3.get("D"));
        System.out.println(hashMap3.get("G"));

        /**
         * V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction
         * key의 value가 존재할 경우에만 func 실행됨 -> func: lambda
         */

        System.out.println(hashMap3.computeIfPresent("E", (s, number) -> number * number)); // null
        System.out.println(hashMap3.computeIfPresent("F", (s, number) -> 10)); // null
        System.out.println(hashMap3.computeIfPresent("A", (s, number) -> 15)); // 15
        System.out.println(hashMap3.get("E")); // null
        System.out.println(hashMap3.get("F")); // null
        System.out.println(hashMap3.get("A")); // 15

        List<String> keyList = new ArrayList<>(hashMap2.keySet());
        keyList.sort(String::compareTo);
        for (String key : keyList) {
            System.out.println("Key: " + key + ", value:" + hashMap2.get(key));
        }

        List<String> valueList = new ArrayList<>(hashMap2.values());
        valueList.sort(String::compareTo);
        for (String value : valueList) {
            System.out.println("Value: " + value);
        }
        System.out.println();

        Comparator<String> comparator = Comparator.naturalOrder();
        Map<String, String> map = new TreeMap<>(comparator);
        map.put("JavaScript", "자바스크립트");
        map.put("Python", "파이썬");
        map.put("Java", "자바");
        map.put("TypeScript", "타입스크립트");
        map.put("C", "씨언어");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println();

        HashMap<String, String> hashMap4 = new HashMap<>();
        hashMap4.put("Nepal", "Kathmandu");
        hashMap4.put("United States", "Washington");
        hashMap4.put("India", "New Delhi");
        hashMap4.put("England", "London");
        hashMap4.put("Australia", "Canberra");

        List<Map.Entry<String, String>> entries = hashMap4.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println();
        List<Map.Entry<String, String>> valueset = hashMap4.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        for (Map.Entry<String, String> entry : valueset) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println();

        Map<String, String> map1 = new LinkedHashMap<>();
        map1.put("Nepal", "Kathmandu");
        map1.put("United States", "Washington");
        map1.put("India", "New Delhi");
        map1.put("England", "London");
        map1.put("Australia", "Canberra");

        Map<String, String> stringMap = sortMapByKey(map1);
        for (Map.Entry<String, String> entry : stringMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        System.out.println();

        Map<String, String> stringMap1 = sortMapByValue(map1);
        for (Map.Entry<String, String> entry : stringMap1.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        boolean isValExist = map1.values().stream().anyMatch("Kathmandu"::equals);
        System.out.println(isValExist);
        boolean isKeyExist = map1.keySet().stream().anyMatch("England"::equals);
        System.out.println(isKeyExist);
    }
}
