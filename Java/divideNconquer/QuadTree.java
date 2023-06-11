package divideNconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadTree {

    public static int[][] img;
    public static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        img = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = bufferedReader.readLine();

            for (int j = 0; j < N; j++) {
                img[i][j] = str.charAt(j) - '0';
            }
        }

        quadTree(0, 0, N);
        System.out.println(builder.toString());
    }

    public static void quadTree(int x, int y, int size) {

        if (isPossible(x, y, size)) {
            builder.append(img[x][y]);
            return;
        }

        int newSize = size / 2;

        builder.append("(");

        quadTree(x, y, newSize);
        quadTree(x, y + newSize, newSize);
        quadTree(x + newSize, y, newSize);
        quadTree(x + newSize, y + newSize, newSize);

        builder.append(")");
    }

    public static boolean isPossible(int x, int y, int size) {

        int value = img[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != img[i][j]) return false;
            }
        }

        return true;
    }
}