package programmers.lv2;

public class MatrixBoundaryTranslationV2 {

    public static int ROWS;
    public static int COLUMNS;
    public static int[][] matrix;
    public static int MIN;

    public int[] solution(int rows, int columns, int[][] queries) {

        ROWS = rows;
        COLUMNS = columns;
        matrix = new int[ROWS][COLUMNS];

        int[] answer = new int[queries.length];

        makeMatrix();

        for (int i = 0; i < queries.length; i++) {
            MIN = Integer.MAX_VALUE;
            parse(queries[i]);
            translate(queries[i][0], queries[i][1], queries[i]);
            answer[i] = MIN;
        }

        return answer;
    }

    public void makeMatrix() {

        for (int i = 0; i < ROWS * COLUMNS; i++) {
            matrix[i / COLUMNS][i % COLUMNS] = i + 1;
        }
    }

    public void parse(int[] query) {

        for (int i = 0; i < query.length; i++) {
            query[i] -= 1;
        }
    }

    public void translate(int x, int y, int[] query) {

        int edge = 0;
        int distX = query[2] - query[0];
        int distY = query[3] - query[1];

        edge = pullRight(x, query[3], distY);
        edge = pullDown(query[2], query[3], distX, edge);
        edge = pullLeft(query[2], y, distY, edge);
        pullUp(x, y, distX, edge);
    }

    public int pullLeft(int x, int y, int dist, int edge) {

        int newEdge = matrix[x][y];

        for (int i = 0; i < dist; i++) {
            if (i == dist - 1) matrix[x][y] = edge;
            else matrix[x][y] = matrix[x][y + 1];
            MIN = Math.min(MIN, matrix[x][y]);
            y++;
        }

        return newEdge;
    }

    public int pullRight(int x, int y, int dist) {

        int newEdge = matrix[x][y];

        for (int i = 0; i < dist; i++) {
            matrix[x][y] = matrix[x][y - 1];
            MIN = Math.min(MIN, matrix[x][y]);
            y--;
        }

        return newEdge;
    }

    public void pullUp(int x, int y, int dist, int edge) {

        for (int i = 0; i < dist; i++) {
            if (i == dist - 1) matrix[x][y] = edge;
            else matrix[x][y] = matrix[x + 1][y];
            MIN = Math.min(MIN, matrix[x][y]);
            x++;
        }
    }

    public int pullDown(int x, int y, int dist, int edge) {

        int newEdge = matrix[x][y];

        for (int i = 0; i < dist; i++) {
            if (i == dist - 1) matrix[x][y] = edge;
            else matrix[x][y] = matrix[x - 1][y];
            MIN = Math.min(MIN, matrix[x][y]);
            x--;
        }

        return newEdge;
    }
}

class example2 {

    public static void main(String[] args) {

        int rows = 6;
        int columns = 6;
        int[][] queries = {
                {2, 2, 5, 4},
                {3, 3, 6, 6},
                {5, 1, 6, 3}

        };
        MatrixBoundaryTranslationV2 v2 = new MatrixBoundaryTranslationV2();
        int[] answer = v2.solution(rows, columns, queries);

        for (int i = 0; i < answer.length; i++)
            System.out.println(answer[i]);
    }
}
