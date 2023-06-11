package backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class infoCctv {
    int x;
    int y;
    int type;

    infoCctv(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}

public class monitoring {

    public static int[] mode = {
            0, 1, 2, 2, 3, 4
    };

    public static int[] rotate = {
            0, 4, 2, 4, 4, 1
    };

    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };

    public static int[][][] cctv = {
            { { 0 } },
            { { 0 }, { 1 }, { 2 }, { 3 } },                             // 1번 CCTV [1][0][0] ~ [1][3][0]
            { { 0, 2 }, { 1, 3 } },                                     // 2번 CCTV [2][0][0] ~ [2][1][1]
            { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } },                 // 3번 CCTV [3][0][0] ~ [3][3][1]
            { { 0, 1, 3 }, { 0, 1, 2 }, { 1, 2, 3 }, { 0, 2, 3 } },     // 4번 CCTV [4][0][0] ~ [4][3][2]
            { { 0, 1, 2, 3 } }                                          // 5번 CCTV [5][0][0] ~ [5][0][3]
    };

    public static int N;
    public static int M;
    public static int[][] office;
    public static ArrayList<infoCctv> cctvs;
    public static int MIN = 64;

    public int solution(int N, int M, int[][] office) {

        init(N, M);
        copy(office, monitoring.office);
        getCctv();
        allCctv();
        return MIN;
    }

    public void init(int N, int M) {
        monitoring.N = N;
        monitoring.M = M;
        monitoring.office = new int[N][M];
        monitoring.cctvs = new ArrayList<>();
    }

    public void getCctv() {
        for (int i = 0; i < office.length; i++) {
            for (int j = 0; j < office[i].length; j++) {
                if (office[i][j] != 0 && office[i][j] != 6) {
                    cctvs.add(new infoCctv(i, j, office[i][j]));
                }
            }
        }
    }

    public void allCctv() {
        findCctv(0);
    }

    public void stateCopy(int[][] state) {
        for (int i = 0; i < office.length; i++) {
            state[i] = office[i].clone();
        }
    }

    public void findCctv(int idx) {

        if (idx == cctvs.size()) {
            MIN = Math.min(MIN, getZeroCount());
            return;
        }

        int cctvNum = cctvs.get(idx).type;
        for (int i = 0; i < rotate[cctvNum]; i++) {
            int[][] state = new int[N][M];
            stateCopy(state);
            backtracking(cctvs.get(idx).x, cctvs.get(idx).y, cctvNum, i);
            findCctv(idx + 1);
            copy(state, office);
        }
    }

    // original을 derivation으로 카피
    public void copy(int[][] original, int[][] derivation) {

        for (int i = 0; i < original.length; i++) {
            derivation[i] = original[i].clone();
        }
    }


    // (x,y) 좌표에서 해당 CCTV가 한 번에 탐색해야 할 모든 방향으로 포워딩
    public void backtracking(int x, int y, int type, int dir) {

        for (int i = 0; i < mode[type]; i++) {
            forward(x, y, type, dir, i);
        }
    }

    // dir 방향에 대해 끝까지 포워딩
    public boolean forward(int x, int y, int type, int dir, int mode) {

        while (true) {
            int nextX = x + dx[cctv[type][dir][mode]];
            int nextY = y + dy[cctv[type][dir][mode]];
            if (!canForward(nextX, nextY)) {
                return true;
            }
            office[nextX][nextY] = -1;
            if (forward(nextX, nextY, type, dir, mode)) return true;
        }
    }

    // 해당 좌표로 포워딩할 수 있는가
    public boolean canForward(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return false;
        return office[x][y] != 6;
    }


    // 한 방향에 대해 모든 CCTV 탐색이 끝난 후, 사각지대의 수
    public int getZeroCount() {

        int counter = 0;
        for (int i = 0; i < office.length; i++) {
            for (int j = 0; j < office[i].length; j++) {
                if (office[i][j] == 0) counter++;
            }
        }
        return counter;
    }
}

class gold6 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);

        int[][] office = new int[N][M];
        for (int i = 0; i < N; i++) {
            token = bufferedReader.readLine().split("\\s");
            office[i] = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();
        }

        monitoring monitoring = new monitoring();
        int answer = monitoring.solution(N, M, office);
        System.out.println(answer);
    }
}
