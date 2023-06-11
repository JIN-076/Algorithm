package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OperatorInsert {

    public static int MIN = 1_000_000_000;
    public static int MAX = -1_000_000_000;
    public static StringBuilder builder = new StringBuilder();

    public void solution(int N, int[] A, int[] Op) {

        calculate(0, N, A, Op, A[0]);
        builder.append(MAX).append("\n");
        builder.append(MIN).append("\n");
        System.out.println(builder);
    }

    public int process(int result, int op, int[] A, int idx) {
        if (op == 0)
            return result + A[idx];
        else if (op == 1)
            return result - A[idx];
        else if (op == 2)
            return result * A[idx];
        else {
            if (result < 0) return -1 * ((-1 * result) / A[idx]);
            else return result / A[idx];
        }
    }

    public void calculate(int idx, int N, int[] A, int[] Op, int result) {

        if (idx == N - 1) {
            MIN = Math.min(MIN, result);
            MAX = Math.max(MAX, result);
            return;
        }

        for (int op = 0; op < 4; op++) {
            if (Op[op] == 0) continue;
            Op[op]--;
            calculate(idx + 1, N, A, Op, process(result, op, A, idx + 1));
            Op[op]++;
        }
    }
}

class test7 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int[] A = new int[N];
        int[] Op = new int[4];
        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(tokenizer.nextToken());
        }
        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int op = 0; op < 4; op++) {
            // Op[0] = '+' / Op[1] = '-' / Op[2] = '*' / Op[3] = '/'
            Op[op] = Integer.parseInt(tokenizer.nextToken());
        }
        OperatorInsert operatorInsert = new OperatorInsert();
        operatorInsert.solution(N, A, Op);
    }
}
