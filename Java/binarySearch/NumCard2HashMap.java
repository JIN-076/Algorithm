package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class NumCard2HashMap {

    public static int N;
    public static int M;
    public static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> map = new HashMap<>();

        N = Integer.parseInt(bufferedReader.readLine());
        String[] token = bufferedReader.readLine().split("\\s");
        int[] card = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < card.length; i++) {
            map.put(card[i], map.getOrDefault(card[i], 0) + 1);
        }

        M = Integer.parseInt(bufferedReader.readLine());
        token = bufferedReader.readLine().split("\\s");
        int[] base = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < base.length; i++) {
            builder.append(map.getOrDefault(base[i], 0)).append(" ");
        }

        System.out.println(builder.toString());
    }
}
