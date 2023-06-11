package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthNumber {

    public static int N;
    public static int K;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        K = Integer.parseInt(bufferedReader.readLine());

        long answer = binarySearch();
        System.out.println(answer);
    }

    public static long binarySearch() {

        long left = 1;
        long right = K;

        while (left < right) {
            long mid = (left + right) / 2;
            if (getCount(mid) >= K) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    public static long getCount(long key) {

        long count = 0;

        for (int i = 1; i <= N; i++) {
            count += Math.min(key / i, N);
        }

        return count;
    }
}
