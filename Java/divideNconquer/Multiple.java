package divideNconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Multiple {

    public static long C;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        long A = Integer.parseInt(token[0]);
        long B = Integer.parseInt(token[1]);
        C = Integer.parseInt(token[2]);

        long answer = pow(A, B);
        System.out.println(answer);
    }

    public static long pow(long A, long exponent) {

        if (exponent == 1) return A % C;

        long tmp = pow(A, exponent / 2);
        if (exponent % 2 == 1) return (tmp * tmp % C) * A % C;

        return tmp * tmp % C;
    }
}
