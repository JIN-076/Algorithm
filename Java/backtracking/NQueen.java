package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.lang.Math;

public class NQueen {

    /**
     * Queen: 자신을 기준으로 일직선상과 대각선 방향에는 아무것도 놓여있으면 안됨
     * 검사: A(i, j), B(k, l)에 대해 |i-k|=|j-l|이면 대각선 상에 놓임
     */

    public int solution(int N) {

        int[] col = new int[N];
        Arrays.fill(col, -1);
        return backtracking(0, N, col);
    }

    public boolean isValid(int[] col, int curRow, int curCol) {
        for (int i = 0; i < curRow; i++) {
            if (col[i] == curCol || Math.abs(curRow - i) == Math.abs(curCol - col[i])) {
                return false;
            }
        }
        return true;
    }

    public int backtracking(int curRow, int N, int[] col) {
        if (curRow == N) return 1;

        int answer;
        answer = 0;

        for (int c = 0; c < N; c++) {
            if (isValid(col, curRow, c)) {
                col[curRow] = c;
                answer += backtracking(curRow + 1, N, col);
                col[curRow] = -1;
            }
        }
        return answer;
    }
}

class test5 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        NQueen nQueen = new NQueen();
        int possible = nQueen.solution(N);
        System.out.println(possible);
    }
}
