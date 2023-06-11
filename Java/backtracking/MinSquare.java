package backtracking;

import java.util.Arrays;

public class MinSquare {
    public static int result = 1_000_000;

    /**
     * 프로그래머스 테스트 케이스 통과
     * 제출: 정답
     */

    public int solution(int[][] sizes) {

        int MAX_W = 0;
        int MAX_H = 0;
        for (int i = 0; i < sizes.length; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            MAX_W = Math.max(w, MAX_W);
            MAX_H = Math.max(h, MAX_H);
        }
        return MAX_W * MAX_H;
    }

    /**
     * 프로그래머스 테스트 케이스 통과
     * 제출: 시간 초과
     */

    public int solution2(int[][] sizes) {
        int N = sizes.length;
        int[][] info = new int[N][2];
        for (int i = 0; i < N; i++) {
            Arrays.fill(info[i], 0);
        }
        bruteforce(0, info, N, sizes);
        return result;
    }

    public void bruteforce(int cur, int[][] info, int N, int[][] sizes) {
        if (cur == N) {
            result = Math.min(info[cur - 1][0] * info[cur - 1][1], result);
            return;
        }

        for (int t = 0; t < 2; t++) {
            compare(cur, t, info, sizes);
            bruteforce(cur + 1, info, N, sizes);
            info[cur][0] = 0;
            info[cur][1] = 0;
        }
    }

    public void compare(int cur, int type, int[][] info, int[][] sizes) {
        if (type == 0) {
            if (cur == 0) {
                info[cur][0] = sizes[cur][0];
                info[cur][1] = sizes[cur][1];
            } else {
                info[cur][0] = Math.max(sizes[cur][0], info[cur - 1][0]);
                info[cur][1] = Math.max(sizes[cur][1], info[cur - 1][1]);
            }
        } else {
            if (cur == 0) {
                info[cur][0] = sizes[cur][1];
                info[cur][1] = sizes[cur][0];
            } else {
                info[cur][0] = Math.max(sizes[cur][1], info[cur - 1][0]);
                info[cur][1] = Math.max(sizes[cur][0], info[cur - 1][1]);
            }
        }
    }
}

class test12 {

    public static void main(String[] args) {

        int[][] sizes = {
                { 14, 4 }, { 19, 6 }, { 6, 16 }, { 18, 7 }, { 7, 11 }
        };

        MinSquare minSquare = new MinSquare();
        System.out.println(minSquare.solution2(sizes));
    }
}

/**
 * [[60, 50], [30, 70], [60, 30], [80, 40]]
 * 4000
 *
 * [[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]
 * 120
 *
 * [[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]
 * 133
 */
