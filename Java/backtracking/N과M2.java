package backtracking;

import java.util.Scanner;

public class N과M2 {

    public void solution(int N, int M) {

        int[] sequence = new int[M];
        boolean[] isExist = new boolean[N];
        for (int i = 0; i < isExist.length; i++) {
            isExist[i] = false;
        }

        pickAsc(0, N, M, sequence, isExist);
    }

    public void pickAsc(int cur, int N, int M, int[] sequence, boolean[] isExist) {
        if (cur == M) {
            printSeq(sequence);
            return;
        }

        int left = findLeft(cur, sequence);

        for (int i = 0; i < N; i++) {
            if (isExist[i]) continue;
            if (i + 1 < left) continue;
            sequence[cur] = i + 1;
            isExist[i] = true;
            pickAsc(cur + 1, N, M, sequence, isExist);
            isExist[i] = false;
            sequence[cur] = 0;
        }
    }

    public int findLeft(int cur, int[] sequence) {
        if (cur <= 0) return -1;
        return sequence[cur - 1];
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

class test2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        N과M2 nm2 = new N과M2();
        nm2.solution(N, M);
    }
}
