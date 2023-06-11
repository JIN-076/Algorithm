package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N과M3 {

    public static StringBuilder builder = new StringBuilder();

    public void solution(int N, int M) {

        int[] sequence = new int[M];

        pick(0, N, M, sequence);
        System.out.println(builder);
    }

    public void pick(int cur, int N, int M, int[] sequence) {
        if (cur == M) {
            printSeq(sequence);
            return;
        }
        for (int i = 0; i < N; i++) {
            sequence[cur] = i + 1;
            pick(cur + 1, N, M, sequence);
            sequence[cur] = 0;
        }
    }

    public void printSeq(int[] sequence) {
        for (int i = 0; i < sequence.length; i++) {
            if (i == sequence.length - 1) {
                builder.append(sequence[i]).append('\n');
            } else {
                builder.append(sequence[i] + " ");
            }
        }
    }
}

class test3 {

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
        N과M3 nm3 = new N과M3();
        nm3.solution(N, M);
    }
}
