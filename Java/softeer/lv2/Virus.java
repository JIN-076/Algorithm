package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Virus {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int K = Integer.parseInt(token[0]);
        int P = Integer.parseInt(token[1]);
        int N = Integer.parseInt(token[2]);

        long answer = K;
        for (int i = 0; i < N; i++) {
            answer *= P;
            answer %= 1000000007;
        }
        System.out.println(answer %= 1000000007);
    }
}
