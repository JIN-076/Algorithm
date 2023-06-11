package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sudoku {

    public static StringBuilder builder = new StringBuilder();

    public void solution(int[][] sudoku) {
        backtracking(0, 0, sudoku);
        System.out.println(builder);
    }

    public boolean checkSection(int curx, int cury, int val, int[][] sudoku) {
        int toX = curx - curx % 3, toY = cury - cury % 3;
        int fromX = toX + 3, fromY = toY + 3;
        while (toX < fromX) {
            while (toY < fromY) {
                if (sudoku[toX][toY] == val) {
                    return false;
                }
                toY++;
            }
            toY = cury - cury % 3;
            toX++;
        }
        return true;
    }

    public boolean checkRow(int curx, int val, int[][] sudoku) {
        for (int c = 0; c < 9; c++) {
            if (sudoku[curx][c] == val)
                return false;
        }
        return true;
    }

    public boolean checkCol(int cury, int val, int[][] sudoku) {
        for (int r = 0; r < 9; r++) {
            if (sudoku[r][cury] == val)
                return false;
        }
        return true;
    }

    public void printSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 8) builder.append(sudoku[i][j]).append("\n");
                else builder.append(sudoku[i][j]).append(" ");
            }
        }
    }

    public boolean backtracking(int curx, int cury, int[][] sudoku) {
        if (curx <= 8 && cury == 9) {
            return backtracking(curx + 1, 0, sudoku);
        } else if (curx == 9 && cury == 0) {
            printSudoku(sudoku);
            return true;
        }

        if (sudoku[curx][cury] != 0) {
            return backtracking(curx, cury + 1, sudoku);
        }

        for (int val = 0; val < 9; val++) {
            if (!checkRow(curx, val + 1, sudoku) ||
                !checkCol(cury, val + 1, sudoku) ||
                !checkSection(curx, cury, val + 1, sudoku)) {
                continue;
            }
            sudoku[curx][cury] = val + 1;
            if (backtracking(curx, cury + 1, sudoku))
                return true;
            sudoku[curx][cury] = 0;
        }
        return false;
    }

}

class test6 {

    public static int[] parse(String[] tokens) {
        int[] sudoku = new int[9];
        for (int i = 0; i < tokens.length; i++) {
            sudoku[i] = Integer.parseInt(tokens[i]);
        }
        return sudoku;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] sudoku = new int[9][9];
        String line;
        try {
            for(int i = 0; i < 9; i++) {
                line = bufferedReader.readLine();
                String[] tokens = line.split("\\s");
                sudoku[i] = parse(tokens);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sudoku sudoku1 = new Sudoku();
        sudoku1.solution(sudoku);
    }
}


