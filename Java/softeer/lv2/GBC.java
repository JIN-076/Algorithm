package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GBC {

    public static int overSpeed = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");

        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);

        int[][] base = new int[N][2];
        for (int i = 0; i < N; i++) {
            token = bufferedReader.readLine().split("\\s");
            base[i][0] = Integer.parseInt(token[0]);
            base[i][1] = Integer.parseInt(token[1]);
        }

        int[][] measure = new int[M][2];
        for (int i = 0; i < M; i++) {
            token = bufferedReader.readLine().split("\\s");
            measure[i][0] = Integer.parseInt(token[0]);
            measure[i][1] = Integer.parseInt(token[1]);
        }

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = idx; j < M; j++) {
                if (measure[j][0] > base[i][0]) {
                    measure[j][0] -= base[i][0];
                    if (measure[j][1] - base[i][1] > 0) overSpeed = Math.max(overSpeed, measure[j][1] - base[i][1]);
                    break;
                } else if (measure[j][0] < base[i][0]) {
                    base[i][0] -= measure[j][0];
                    if (measure[j][1] - base[i][1] > 0) overSpeed = Math.max(overSpeed, measure[j][1] - base[i][1]);
                    idx++;
                } else {
                    if (measure[j][1] - base[i][1] > 0) overSpeed = Math.max(overSpeed, measure[j][1] - base[i][1]);
                    idx++;
                    break;
                }
            }
        }
        System.out.println(overSpeed);
    }
}
