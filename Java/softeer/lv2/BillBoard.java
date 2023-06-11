package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BillBoard {

    public static int[][] digits = {
            { 1, 1, 1, 1, 1, 1, 0 },
            { 0, 1, 1, 0, 0, 0, 0 },
            { 1, 1, 0, 1, 1, 0, 1 },
            { 1, 1, 1, 1, 0, 0, 1 },
            { 0, 1, 1, 0, 0, 1, 1 },
            { 1, 0, 1, 1, 0, 1, 1 },
            { 1, 0, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 0, 1, 0 },
            { 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 0, 1, 1 },
            { 0, 0, 0, 0, 0, 0, 0}
    };

    public static int digit(int num) {
        int cnt = 0;
        do {
            num /= 10;
            cnt += 1;
        } while (num > 0);
        return cnt;
    }

    public static int checkDigit(int digit, int A, int B, int digitA, int digitB) {
        int numA = 0;
        int numB = 0;
        numA = (A /= Math.pow(10, digit - 1));
        numB = (B /= Math.pow(10, digit - 1));
        if (digit > digitA) numA = 10;
        else numA %= 10;
        if (digit > digitB) numB = 10;
        else numB %= 10;

        if (numA == numB) return 0;

        int cnt = 0;
        for (int i = 0; i < digits[0].length; i++) {
            if (digits[numA][i] == digits[numB][i]) continue;
            cnt += 1;
        }
        return cnt;
    }

    public static void main(String args[]) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < test_case; i++) {
            String[] token = bufferedReader.readLine().split("\\s");
            int A = Integer.parseInt(token[0]);
            int B = Integer.parseInt(token[1]);

            int answer = 0;
            for (int j = 0; j < 5; j++) {
                answer += checkDigit(j + 1, A, B, digit(A), digit(B));
            }
            System.out.println(answer);
        }
    }
}
