package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanComputer {

    public static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();

        int[][] sum = new int[str.length()][26];
        sum[0][str.charAt(0) - 'a']++;

        for (int i = 1; i < str.length(); i++) {
            int tmp = str.charAt(i) - 'a';

            for (int j = 0; j < 26; j++) {
                sum[i][j] = sum[i - 1][j];
            }
            sum[i][tmp]++;
        }

        int Q = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < Q; i++) {
            String[] token = bufferedReader.readLine().split("\\s");
            char alphabet = token[0].charAt(0);
            int start = Integer.parseInt(token[1]);
            int end = Integer.parseInt(token[2]);

            if (start == 0) builder.append(sum[end][alphabet -'a']).append("\n");
            else builder.append(sum[end][alphabet - 'a'] - sum[start - 1][alphabet - 'a']).append("\n");
        }

        System.out.println(builder.toString());
    }
}
