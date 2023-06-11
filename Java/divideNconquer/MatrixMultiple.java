package divideNconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixMultiple {

    public static StringBuilder builder = new StringBuilder();
    public static int[][] matrixA;
    public static int[][] matrixB;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);

        matrixA = new int[N][M];
        for (int i = 0; i < N; i++) {
            token = bufferedReader.readLine().split("\\s");
            matrixA[i] = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();
        }

        token = bufferedReader.readLine().split("\\s");
        int K = Integer.parseInt(token[1]);
        matrixB = new int[M][K];
        for (int i = 0; i < M; i++) {
            token = bufferedReader.readLine().split("\\s");
            matrixB[i] = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                int sum = 0;
                for (int k = 0; k < M; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                builder.append(sum).append(" ");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}
