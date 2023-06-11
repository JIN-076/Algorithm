package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindNum {

    public static int[] A;
    public static int[] base;

    public static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());

        String[] token = bufferedReader.readLine().split("\\s");
        A = new int[N];
        A = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(bufferedReader.readLine());

        token = bufferedReader.readLine().split("\\s");
        base = new int[M];
        base = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(A);

        for (int i = 0; i < base.length; i++) {
            if (Arrays.binarySearch(A, base[i]) >= 0) builder.append(1).append("\n");
            else builder.append(0).append("\n");
        }

        System.out.println(builder.toString());
    }

    public static int binarySearch(int key) {

        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (key < A[mid]) right = mid - 1;
            else if (key > A[mid]) left = mid + 1;
            else return mid;
        }
        return -1;
    }
}
