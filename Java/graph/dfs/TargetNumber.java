package graph.dfs;

import java.util.Arrays;

public class TargetNumber {

    public static int[] Op = { -1, 1 };

    public int solution(int[] numbers, int target) {
        int answer = 0;
        boolean[] used = new boolean[numbers.length];
        Arrays.fill(used, false);
        answer = dfs(0, 0, used, numbers, target);
        return answer;
    }

    public boolean isTarget(int res, int target) {
        return res == target;
    }

    public int dfs(int cur, int res, boolean[] used, int[] numbers, int target) {
        if (cur == numbers.length) {
            if (isTarget(res, target)) return 1;
            return 0;
        }

        int answer;
        answer = 0;

        for (int op = 0; op < 2; op++) {
            if (used[cur]) continue;
            used[cur] = true;
            answer += dfs(cur + 1, res + (Op[op] * numbers[cur]), used, numbers, target);
            used[cur] = false;
        }
        return answer;
    }
}

class test16 {

    public static void main(String[] args) {

        int[] numbers = { 1, 1, 1, 1, 1 };
        int target = 3;
        TargetNumber targetNumber = new TargetNumber();
        targetNumber.solution(numbers, target);
    }
}

/**
 * [1, 1, 1, 1, 1] 3
 * 5
 *
 * [4, 1, 2, 1] 4
 * 2
 */