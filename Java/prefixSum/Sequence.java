package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sequence {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(token[0]);
        int K = Integer.parseInt(token[1]);

        int[] temperature = new int[N + 1];
        int[] sum = new int[N + 1];

        temperature[0] = 0;
        sum[0]= 0;

        token = bufferedReader.readLine().split("\\s");

        for (int i = 1; i <= N; i++) {
            temperature[i] = Integer.parseInt(token[i - 1]);
            if (i == 1) sum[i] = temperature[i];
            else sum[i] = sum[i - 1] + temperature[i];
        }

        int MAX = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            MAX = Math.max(MAX, sum[i] - sum[i - K]);
        }

        System.out.println(MAX);
    }
}
