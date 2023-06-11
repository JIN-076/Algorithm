package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N과M1 {

    public void solution(int N, int M) {

        int[] sequence = new int[M];
        boolean[] isExist = new boolean[N];
        for (int i = 0; i < isExist.length; i++) {
            isExist[i] = false;
        }

        pick(0, N, M, sequence, isExist);
    }

    public void pick(int cur, int N, int M, int[] sequence, boolean[] isExist) {
        if (cur == M) {
            printSeq(sequence);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isExist[i]) continue;
            sequence[cur] = i + 1;
            isExist[i] = true;
            pick(cur + 1, N, M, sequence, isExist);
            sequence[cur] = 0;
            isExist[i] = false;
        }
    }

    public void printSeq(int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            if (i == sequence.length - 1) {
                System.out.println(sequence[i]);
            } else {
                System.out.print(sequence[i] + " ");
            }
        }
    }

}

class test {

    public static void main(String[] args) throws IOException {

    /**
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
    */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        N과M1 nm1 = new N과M1();
        nm1.solution(N, M);
        bufferedReader.close();
    }
}
