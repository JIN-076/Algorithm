package backjoon.gold;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Snake {

    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };

    public static int time = 0;
    public static int body = 1;
    public static int[][] board;
    public static int[][] apples;
    public static int[] infos_time;
    public static char[] infos_dir;
    public static boolean[] isEat;
    public static ArrayList<Point> snake;

    public int solution(int N, int K, int[][] apple, int[] info_time, char[] info_dir) {

        board = new int[N][N];
        apples = apple;
        infos_time = info_time;
        infos_dir = info_dir;
        isEat = new boolean[apple.length];
        snake = new ArrayList<>();

        parse();
        snake.add(new Point(0, 0));
        rotate();

        return time;
    }

    public void parse() {
        for (int i = 0; i < apples.length; i++) {
            apples[i][0] -= 1;
            apples[i][1] -= 1;
        }
    }

    public int turnLeft(int dir) {
        return (dir - 1 < 0) ? 3 : dir - 1;
    }

    public int turnRight(int dir) {
        return (dir + 1 > 3) ? 0 : dir + 1;
    }

    public boolean isExistApple(int x, int y) {
        for (int i = 0; i < apples.length; i++) {
            if (!isEat[i] && x == apples[i][0] && y == apples[i][1]) {
                isEat[i] = true;
                return true;
            }
        }
        return false;
    }

    public boolean isReachBody(int x, int y) {
        if (snake.contains(new Point(x, y))) return true;
        return false;
    }

    public boolean forward(int x, int y, int d, int info_time) {

        boolean died = false;
        while (time != info_time) {
            ++time;
            int nextX = snake.get(0).x + dx[d];
            int nextY = snake.get(0).y + dy[d];
            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) {
                died = true;
                break;
            }
            if (isReachBody(nextX, nextY)) {
                died = true;
                break;
            }
            boolean ret = isExistApple(nextX, nextY);
            if (ret) {
                ++body;
                snake.add(0, new Point(nextX, nextY));
            } else {
                snake.remove(snake.size() - 1);
                snake.add(0, new Point(nextX, nextY));
            }
        }
        return died;
    }

    public void rotate() {

        char tmp = '\u0000';
        int d = 1;
        for (int i = 0; i < infos_time.length; i++) {
            if (tmp == '\u0000') {
                if (forward(snake.get(0).x, snake.get(0).y, d, infos_time[i])) return;
                tmp = infos_dir[i];
            }
            else {
                if (tmp == 'L') {
                    d = turnLeft(d);
                    if (forward(snake.get(0).x, snake.get(0).y, d, infos_time[i])) return;
                } else {
                    d = turnRight(d);
                    if (forward(snake.get(0).x, snake.get(0).y, d, infos_time[i])) return;
                }
                tmp = infos_dir[i];
            }
        }
        if (tmp == 'L') {
            d = turnLeft(d);
            if (forward(snake.get(0).x, snake.get(0).y, d, 10000)) return;
        } else {
            d = turnRight(d);
            if (forward(snake.get(0).x, snake.get(0).y, d, 10000)) return;
        }
    }
}

class gold2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int K = Integer.parseInt(bufferedReader.readLine());

        String[] token;

        int[][] apple = new int[K][2];
        for (int i = 0; i < K; i++) {
            token = bufferedReader.readLine().split("\\s");
            apple[i] = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();
        }

        int L = Integer.parseInt(bufferedReader.readLine());

        int[] info_time = new int[L];
        char[] info_dir = new char[L];
        for (int i = 0; i < L; i++) {
            token = bufferedReader.readLine().split("\\s");
            info_time[i] = Integer.parseInt(token[0]);
            info_dir[i] = token[1].charAt(0);
        }

        Snake snake = new Snake();
        int answer = snake.solution(N, K, apple, info_time, info_dir);
        System.out.println(answer);
    }
}
