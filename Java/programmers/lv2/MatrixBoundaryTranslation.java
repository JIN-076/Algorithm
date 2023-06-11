package programmers.lv2;

import java.util.*;

class MatrixBoundaryTranslation {

    public static int ROWS;
    public static int COLUMNS;

    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static int[][] matrix;
    public static int[][] after;

    public int[] solution(int rows, int columns, int[][] queries) {

        ROWS = rows;
        COLUMNS = columns;

        int[] answer = new int[queries.length];
        matrix = new int[rows][columns];
        after = new int[rows][columns];
        fill();

        for (int i = 0; i < queries.length; i++) {
            pq.clear();
            parse(queries[i]);
            getBoundary(queries[i]);
            printMatrix();
            copy();
            answer[i] = pq.poll();
        }
        return answer;
    }

    public void parse(int[] query) {
        for (int i = 0; i < query.length; i++) {
            query[i] -= 1;
        }
    }

    public void printMatrix() {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < after.length; i++) {
            for (int j = 0; j < after[i].length; j++) {
                System.out.print(after[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public void copy() {
        for (int i = 0; i < after.length; i++) {
            matrix[i] = after[i].clone();
        }
    }

    public void fill() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                matrix[i][j] = getBlockNumber(i, j + 1, ROWS, COLUMNS);
                after[i][j] = getBlockNumber(i, j + 1, ROWS, COLUMNS);
            }
        }
    }

    public int getBlockNumber(int row, int column, int rows, int columns) {
        return row * columns + column;
    }

    public void getBoundary(int[] query) {
        for (int i = query[0]; i <= query[2]; i++) {
            for (int j = query[1]; j <= query[3]; j++) {
                if (i == query[0] || i == query[2]) {
                    pq.add(matrix[i][j]);
                    if (i == query[0]) {
                        if (j != query[3]) after[i][j + 1] += matrix[i][j];
                        else after[i + 1][j] += matrix[i][j];
                    } else {
                        if (j != query[1]) after[i][j - 1] += matrix[i][j];
                        else after[i - 1][j] += matrix[i][j];
                    }
                    after[i][j] -= matrix[i][j];
                }
                else if (j == query[1] || j == query[3]) {
                    pq.add(matrix[i][j]);
                    if (j == query[1]) {
                        if (i != query[0] && i != query[2]) after[i - 1][j] += matrix[i][j];
                    } else {
                        if (i != query[0] && i != query[2]) after[i + 1][j] += matrix[i][j];
                    }
                    after[i][j] -= matrix[i][j];
                }
            }
        }
    }
}

class example {

    public static void main(String[] args) {

        int rows = 6;
        int columns = 6;
        int[][] queries = {
                {2, 2, 5, 4},
                {3, 3, 6, 6},
                {5, 1, 6, 3}

        };
        MatrixBoundaryTranslation matrixBoundary = new MatrixBoundaryTranslation();
        int[] answer = matrixBoundary.solution(rows, columns, queries);

        for (int i = 0; i < answer.length; i++)
            System.out.println(answer[i]);
    }
}

/**
 * int[][] queries = {
 *                 { 2, 2, 5, 4 },
 *                 { 3, 3, 6, 6 },
 *                 { 5, 1, 6, 3 }
 *         };
 */