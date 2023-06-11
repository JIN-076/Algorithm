package backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class robotCleaner {

    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };
    public static int counter = 0;

    public int solution(int r, int c, int d, int[][] place) {

        clean(r, c, d, place, false);
        return counter;
    }

    public int rotate(int dir) {
        return (dir - 1 < 0) ? 3 : dir - 1;
    }

    public int back(int dir) {
        return (dir - 2 < 0) ? dir + 2 : dir - 2;
    }

    public boolean isExistBlack(int r, int c, int[][] place) {

        for (int dir = 0; dir < 4; dir++) {
            int nextX = r + dx[dir];
            int nextY = c + dy[dir];
            if (nextX < 0 || nextX >= place.length || nextY < 0 || nextY >= place[0].length) continue;
            if (place[nextX][nextY] == 1) continue; // 현재 칸의 주변 4칸 중 벽
            if (place[nextX][nextY] == 2) continue; // 현재 칸의 주변 4칸 중 청소됨
            return true;
        }
        return false;
    }

    public boolean clean(int r, int c, int d, int[][] place, boolean isBack) {

        if (!isBack) { // 후진 아님
            if (place[r][c] == 1) return true;
            else if (place[r][c] == 2) return true;
            else {
                ++counter;
                place[r][c] = 2;
            }
        } else { // 후진. 빈칸 없음.
            if (place[r][c] == 1) return false;
            else if (place[r][c] == 0) {
                ++counter;
                place[r][c] = 2;
            }
        }

        boolean ret = isExistBlack(r, c, place);
        if (ret) {
            for (int dir = 0; dir < 4; dir++) {
                d = rotate(d);
                if (!clean(r + dx[d], c + dy[d], d, place, false)) return false;
            }
        } else {
            if (!clean(r + dx[back(d)], c + dy[back(d)], d, place, true)) return false;
        }
        return false;
    }
}

class gold1 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);

        token = bufferedReader.readLine().split("\\s");
        int r = Integer.parseInt(token[0]);
        int c = Integer.parseInt(token[1]);
        int d = Integer.parseInt(token[2]);

        int[][] place = new int[N][M];

        for (int i = 0; i < N; i++) {
            token = bufferedReader.readLine().split("\\s");
            place[i] = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();
        }

        robotCleaner robotCleaner = new robotCleaner();
        int answer = robotCleaner.solution(r, c, d, place);
        System.out.println(answer);
    }
}
