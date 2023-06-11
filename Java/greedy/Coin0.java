package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin0 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(token[0]);
        int K = Integer.parseInt(token[1]);

        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int count = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (coin[i] <= K) {
                count += (K / coin[i]);
                K = K % coin[i];
            }
        }

        System.out.println(count);
    }
}
