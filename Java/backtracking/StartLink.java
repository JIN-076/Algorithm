package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StartLink {

    public static int MIN = Integer.MAX_VALUE;

    public void solution(int N, int[][] S)  {

        int[] isStartTeam = new int[N / 2];
        boolean[] used = new boolean[N];
        Arrays.fill(isStartTeam, -1);
        Arrays.fill(used, false);

        backtracking(0, N, used, isStartTeam, S);
        System.out.println(MIN);
    }

    public int calculateStart(boolean[] used, int N, int[][] S) {
        int startStats = 0;
        int linkStats = 0;
        for (int i = 0; i < used.length; i++) {
            for (int j = i; j < used.length; j++) {
                if (i == j) continue;
                if (used[i] && used[j]) {
                    startStats += S[i][j];
                    startStats += S[j][i];
                } else if (!used[i] && !used[j]) {
                    linkStats += S[i][j];
                    linkStats += S[j][i];
                }
            }
        }
        return Math.abs(startStats - linkStats);
    }

    public int findLeftMember(int cur, int[] isStartTeam) {
        if (cur <= 0) return -1;
        return isStartTeam[cur - 1];
    }

    public void backtracking(int cur, int N, boolean[] used, int[] isStartTeam, int[][] S) {
        if (cur == N / 2) {
            MIN = Math.min(calculateStart(used, N, S), MIN);
            return;
        }

        int left = findLeftMember(cur, isStartTeam);

        for (int m = 0; m < N; m++) {
            if (isStartTeam[cur] != -1) continue;
            if (used[m]) continue;
            if (m < left) continue;
            isStartTeam[cur] = m;
            used[m] = true;
            backtracking(cur + 1, N, used, isStartTeam, S);
            isStartTeam[cur] = -1;
            used[m] = false;
        }
    }
}

class test8 {

    public static int[] parse(String[] tokens) {
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int[][] S = new int[N][N];
        String line;
        for (int i = 0; i < N; i++) {
            line = bufferedReader.readLine();
            String[] tokens = line.split("\\s");
            S[i] = parse(tokens);
        }
        StartLink startLink = new StartLink();
        startLink.solution(N, S);
    }
}
