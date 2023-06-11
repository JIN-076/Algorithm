package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardCover {

    public static int[][][] coverType = {
            { { 0, 0 }, { 1, 0 }, { 1, 1 } },
            { { 0, 0 }, { 0, 1 }, { 1, 0 } },
            { { 0, 0 }, { 0, 1 }, { 1, 1 } },
            { { 0, 0 }, { 1, 0 }, { 1, -1 } }
    };

    public int solution(int[][] board) {
        int ret = 0;
        int N = getBlockCount(board);
        if (N % 3 != 0) return ret;
        ret = fill(0, N, board);
        return ret;
    }

    public int getBlockCount(int[][] board) {
        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    public int fill(int idx, int N, int[][] board) {

        int curx = -1, cury = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) continue;
                curx = i;
                cury = j;
                break;
            }
            if (cury != -1) break;
        }

        if (cury == -1) return 1;

        int ret;
        ret = 0;

        for (int t = 0; t < 4; t++) {
            if (cover(curx, cury, t, 1, board))
                ret += fill(idx + 3, N, board);
            cover(curx, cury, t, -1, board);
        }
        return ret;
    }

    /**
     * board[nextX][nextY]
     * 0: 흰 칸
     * 1: 검은 칸
     *
     * flag
     * 1: 덮는 행위
     * -1: 치우는 행위
     *
     * board[nextX][nextY] += flag
     * 1: 흰 칸에 덮는 행위
     * 2: 검은 칸에 덮는 행위 -> 예외
     */

    public boolean cover(int curx, int cury, int type, int flag, int[][] board) {
        boolean ret = true;

        for (int i = 0; i < 3; i++) {
            int nextX = curx + coverType[type][i][0];
            int nextY = cury + coverType[type][i][1];
            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) ret = false;
            else if ((board[nextX][nextY] += flag) > 1) ret = false;
        }
        return ret;
    }
}

class test11 {

    public static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] parse(String line) {
        int[] tokens = new int[line.length()];
        for (int i = 0; i < line.length(); i++) {
            if (Character.toString(line.charAt(i)).equals("#")) tokens[i] = 1;
            else tokens[i] = 0;
        }
        return tokens;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int H = 8;
        int W = 10;
        int[][] board = new int[H][W];
        String line;
        for (int i = 0; i < H; i++) {
            line = bufferedReader.readLine();
            board[i] = parse(line);
        }
        BoardCover boardCover = new BoardCover();
        System.out.println(boardCover.solution(board));
    }
}

/**
 * 3 7
 * #.....#
 * #.....#
 * ##...##
 *
 * 3 7
 * #.....#
 * #.....#
 * ##..###
 *
 * 8 10
 * ##########
 * #........#
 * #........#
 * #........#
 * #........#
 * #........#
 * #........#
 * ##########
 */
