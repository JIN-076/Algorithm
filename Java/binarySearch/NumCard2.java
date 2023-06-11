package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumCard2 {

    public static int N;
    public static int M;
    public static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        String[] token = bufferedReader.readLine().split("\\s");
        int[] card = new int[N];
        card = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();

        M = Integer.parseInt(bufferedReader.readLine());
        token = bufferedReader.readLine().split("\\s");
        int[] base = new int[M];
        base = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(card);

        for (int i = 0; i < base.length; i++) {
            int lower = lowerBound(card, base[i]);
            int upper = upperBound(card, base[i]);
            builder.append(upper - lower).append(" ");
        }

        System.out.println(builder.toString());
    }

    public static int lowerBound(int[] card, int key) {

        int left = 0;
        int right = card.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (card[mid] >= key) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    public static int upperBound(int[] card, int key) {

        int left = 0;
        int right = card.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (card[mid] > key) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}
