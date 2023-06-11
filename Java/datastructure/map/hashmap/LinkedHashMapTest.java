package datastructure.map.hashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

    public static void main(String[] args) {

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("apple", "사과");
        linkedHashMap.put("banana", "바나나");
        linkedHashMap.put("kiwi", "키위");

        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
            System.out.println("[Key]: " + entry.getKey() + ", [Value]: " + entry.getValue());
        }
    }
}
