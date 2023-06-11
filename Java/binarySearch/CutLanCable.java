package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CutLanCable {

    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int K = Integer.parseInt(token[0]);
        N = Integer.parseInt(token[1]);

        int[] Lan = new int[K];
        for (int i = 0; i < K; i++) {
            Lan[i] = Integer.parseInt(bufferedReader.readLine());
        }

        Arrays.sort(Lan);

        long answer = binarySearch(Lan);
        System.out.println(answer);
    }

    public static long binarySearch(int[] Lan) {

        long left = 0;
        long right = Lan[Lan.length - 1];

        right++;

        while (left < right) {
            long mid = (left + right) / 2;

            if (getLanCable(Lan, mid) < N) right = mid;
            else left = mid + 1;
        }

        return left - 1;
    }

    public static long getLanCable(int[] Lan, long key) {

        long cnt = 0;

        for (int i = 0; i < Lan.length; i++) {
            cnt += (Lan[i] / key);
        }

        return cnt;
    }
}
