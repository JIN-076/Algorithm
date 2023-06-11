package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CutTree {

    public static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(token[0]);
        M = Integer.parseInt(token[1]);

        token = bufferedReader.readLine().split("\\s");
        int[] tree = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(tree);

        long answer = binarySearch(tree);
        System.out.println(answer);
    }

    public static long binarySearch(int[] tree) {

        long left = 0;
        long right = tree[tree.length - 1];

        right++;

        while (left < right) {
            long mid = (left + right) / 2;
            if (getTreeLength(tree, mid) < M) right = mid;
            else left = mid + 1;
        }

        return left - 1;
    }

    public static long getTreeLength(int[] tree, long key) {

        long length = 0;

        for (int i = 0; i < tree.length; i++) {
            long tmp = (long) tree[i] - key;
            if (tmp < 0) continue;
            length += tmp;
        }

        return length;
    }
}
