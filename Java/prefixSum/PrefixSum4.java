package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrefixSum4 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);

        int[] prefixSum = new int[N + 1];
        token = bufferedReader.readLine().split("\\s");
        for (int i = 1; i <= token.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(token[i - 1]);
        }


        for (int i = 0; i < M; i++) {
            token = bufferedReader.readLine().split("\\s");
            int start = Integer.parseInt(token[0]);
            int end = Integer.parseInt(token[1]);
            System.out.println(prefixSum[end] - prefixSum[start - 1]);
        }
    }
}
