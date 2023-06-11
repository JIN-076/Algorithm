package graph.dfs;

import java.awt.*;
import java.util.*;

public class FillPuzzle {

    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };
    public static int[][][] puzzle = new int[6][6][2];
    public static int[][][] blank = new int[6][6][2];

    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;

        boolean[] isUsed = new boolean[50];
        Queue<Point> puzzles = new LinkedList<>();
        Queue<Point> blanks = new LinkedList<>();

        for (int[][] value : puzzle) {
            for (int[] values : value) {
                Arrays.fill(values, -100);
            }
        }

        for (int[][] value : blank) {
            for (int[] values : value) {
                Arrays.fill(values, -100);
            }
        }

        parsePuzzle(puzzles, 0, 0, table);
        parseBlank(blanks, 0, 0, game_board);

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                else return Integer.compare(o1[0], o2[0]);
            }
        };

        for (int i = 0; i < blank.length; i++) {
            Arrays.sort(blank[i], comparator);
            Arrays.sort(puzzle[i], comparator);
        }

        printPuzzle();
        printBlank();

        return answer;
    }

    public void printPuzzle() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                for (int k = 0; k < puzzle[i][j].length; k++) {
                    System.out.print(puzzle[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public void printBlank() {
        for (int i = 0; i < blank.length; i++) {
            for (int j = 0; j < blank[i].length; j++) {
                for (int k = 0; k < blank[i][j].length; k++) {
                    System.out.print(blank[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public int getBlank(int[][] game_board) {
        int cnt = 0;
        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[i].length; j++) {
                if (game_board[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    public boolean isValidPuzzle(int curx, int cury, int[][] table) {
        if (curx < 0 || curx > 5 || cury < 0 || cury > 5) return false;
        if (table[curx][cury] == 0) return false;
        else table[curx][cury] -= 1;
        return true;
    }

    public boolean isValidBoard(int curx, int cury, int[][] game_board) {
        if (curx < 0 || curx > 5 || cury < 0 || cury > 5) return false;
        if (game_board[curx][cury] == 1) return false;
        else game_board[curx][cury] += 1;
        return true;
    }

    public void parsePuzzle(Queue<Point> puzzles, int idx, int block, int[][] table) {
        int x = -1;
        int y = -1;

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 0 || table[i][j] == -1) continue;
                x = i;
                y = j;
                break;
            }
            if (y != -1) break;
        }

        if (y == -1) return;

        puzzles.add(new Point(x, y));
        table[x][y] -= 1;
        puzzle[idx][block][0] = x - x;
        puzzle[idx][block][1] = y - y;

        while (!puzzles.isEmpty()) {
            Point front = puzzles.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nextX = front.x + dx[dir];
                int nextY = front.y + dy[dir];
                if (!isValidPuzzle(nextX, nextY, table)) continue;
                puzzles.add(new Point(nextX, nextY));
                block++;
                puzzle[idx][block][0] = nextX - x;
                puzzle[idx][block][1] = nextY - y;
            }
        }
        parsePuzzle(puzzles, idx + 1, 0, table);
    }

//    public boolean isRightPuzzle(int[][] blank, int[][] puzzle) {
//        Comparator<int[]> comparator = new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
//                else return Integer.compare(o1[0], o2[0]);
//            }
//        };
//        Arrays.sort(blank, comparator);
//        Arrays.sort(puzzle, comparator);
//        for (int i = 0; i < blank.length; i++) {
//            for (int j = 0; j < blank[i].length; j++) {
//                if (blank[i][j] == -100 && puzzle[i][j] == -100) continue;
//                if (blank[i][j] == -100 || puzzle[i][j] == -100) return false;
//
//            }
//        }
//    }

    public void parseBlank(Queue<Point> blanks, int idx, int block, int[][] game_board) {
        int x = -1;
        int y = -1;

        for (int i = 0; i < game_board.length; i++) {
            for (int j = 0; j < game_board[i].length; j++) {
                if (game_board[i][j] == 1) continue;
                x = i;
                y = j;
                break;
            }
            if (y != -1) break;
        }

        if (y == -1) return;

        blanks.add(new Point(x, y));
        game_board[x][y] += 1;
        blank[idx][block][0] = x - x;
        blank[idx][block][1] = y - y;

        while (!blanks.isEmpty()) {
            Point front = blanks.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nextX = front.x + dx[dir];
                int nextY = front.y + dy[dir];
                if (!isValidBoard(nextX, nextY, game_board)) continue;
                blanks.add(new Point(nextX, nextY));
                block++;
                blank[idx][block][0] = nextX - x;
                blank[idx][block][1] = nextY - y;
            }
        }
        parseBlank(blanks, idx + 1, 0, game_board);
    }
}

class test23 {

    public static void main(String[] args) {

        int[][] game_board = {
                { 1, 1, 0, 0, 1, 0 },
                { 0, 0, 1, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 1 },
                { 1, 1, 0, 1, 1, 1 },
                { 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 1, 0, 0 }
        };
        int[][] table = {
                { 1, 0, 0, 1, 1, 0 },
                { 1, 0, 1, 0, 1, 0 },
                { 0, 1, 1, 0, 1, 1 },
                { 0, 0, 1, 0, 0, 0 },
                { 1, 1, 0, 1, 1, 0 },
                { 0, 1, 0, 0, 0, 0 }
        };
        FillPuzzle fillPuzzle = new FillPuzzle();
        int answer = fillPuzzle.solution(game_board, table);
        System.out.println(answer);
    }
}