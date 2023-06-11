package divideNconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixPow {

    public static int N;
    public static int[][] matrix;
    public static int MOD = 1000;
    public static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        N = Integer.parseInt(token[0]);
        long B = Long.parseLong(token[1]);

        matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            token = bufferedReader.readLine().split("\\s");
            matrix[i] = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] %= MOD;
            }
        }

        int[][] result = pow(matrix, B);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                builder.append(result[i][j]).append(" ");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    public static int[][] pow(int[][] matrix, long exp) {

        if (exp == 1L) return matrix;

        int[][] ret = pow(matrix, exp / 2);
        ret = multiple(ret, ret);
        if (exp % 2 == 1L) ret = multiple(ret, matrix);
        return ret;
    }

    public static int[][] multiple(int[][] o1, int[][] o2) {

        int[][] ret = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    ret[i][j] += o1[i][k] * o2[k][j];
                    ret[i][j] %= MOD;
                }
            }
        }

        return ret;
    }
}
