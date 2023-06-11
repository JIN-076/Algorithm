package divideNconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PaperCount {

    public static int[][] paper;
    public static int GRAY = 0; // -1
    public static int WHITE = 0; // 0
    public static int BLACK = 0; // 1

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] token = bufferedReader.readLine().split("\\s");
            paper[i] = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();
        }

        partition(0, 0, N);
        System.out.println(GRAY);
        System.out.println(WHITE);
        System.out.println(BLACK);
    }

    public static void partition(int row, int col, int size) {

        if (colorCheck(row, col, size)) {
            if (paper[row][col] == -1) GRAY++;
            else if (paper[row][col] == 0) WHITE++;
            else BLACK++;
            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + 2 * newSize, newSize);

        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + 2 * newSize, newSize);

        partition(row + 2 * newSize, col, newSize);
        partition(row + 2 * newSize, col + newSize, newSize);
        partition(row + 2 * newSize, col + 2 * newSize, newSize);
    }

    public static boolean colorCheck(int row, int col, int size) {

        int color = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != paper[i][j]) return false;
            }
        }

        return true;
    }
}
