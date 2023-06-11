package divideNconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MakeColoredPaper {

    public int N;
    public int white;
    public int blue;
    public int[][] coloredPaper;

    MakeColoredPaper(int N, int[][] coloredPaper) {
        this.N = N;
        this.white = 0;
        this.blue = 0;
        this.coloredPaper = coloredPaper;
    }

    public void solution() {
        partition(0, 0, N);
        System.out.println(this.white);
        System.out.println(this.blue);
    }

    public void partition(int row, int col, int size) {

        if (colorCheck(row, col, size)) {
            if (this.coloredPaper[row][col] == 0) this.white++;
            else this.blue++;
            return;
        }

        int newSize = size / 2;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
    }

    public boolean colorCheck(int row, int col, int size) {

        int color = this.coloredPaper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (this.coloredPaper[i][j] != color) return false;
            }
        }

        return true;
    }
}

class test43 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        int[][] coloredPaper = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] token = bufferedReader.readLine().split("\\s");
            coloredPaper[i] = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();
        }

        MakeColoredPaper makeColoredPaper = new MakeColoredPaper(N, coloredPaper);
        makeColoredPaper.solution();
    }
}
