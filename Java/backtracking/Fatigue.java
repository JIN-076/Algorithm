package backtracking;

import java.util.Arrays;

public class Fatigue {

    public static int MAX = 0;
    public static int ans = 0;

    public int solution(int k, int[][] dungeons) {

        boolean[] used = new boolean[dungeons.length];
        Arrays.fill(used, false);
        explore(0, used, k, 0, dungeons);
        return MAX;
    }

    public int solution2(int k, int[][] dungeons) {

        boolean[] used = new boolean[dungeons.length];
        Arrays.fill(used, false);
        dfs(0, used, k, dungeons);
        return ans;
    }

    public boolean isPossible(int cur, int k, int[][] dungeons) {
        return k >= dungeons[cur][0];
    }

    public void explore(int cur, boolean[] used, int k, int answer, int[][] dungeons) {
        if (cur == dungeons.length) {
            MAX = Math.max(MAX, answer);
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            if (isPossible(i, k, dungeons)) {
                k -= dungeons[i][1];
                explore(cur + 1, used, k, answer + 1, dungeons);
                k += dungeons[i][1];
            }
            else explore(cur + 1, used, k, answer, dungeons);
            used[i] = false;
        }
    }

    public void dfs(int hit, boolean[] used, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!used[i] && isPossible(i, k, dungeons)) {
                used[i] = true;
                dfs(hit + 1, used, k - dungeons[i][1], dungeons);
                used[i] = false;
            }
        }
        ans = Math.max(ans, hit);
    }
}

class test15 {

    public static void main(String[] args) {

        int k = 80;
        int[][] dungeons = {
                { 80, 20 }, { 50, 40 }, { 30, 10 }
        };
        Fatigue fatigue = new Fatigue();
        int result = fatigue.solution2(k, dungeons);
        System.out.println(result);
    }
}
