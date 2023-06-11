package divideNconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinomialCoefficient2 {

    public static int P = 10007;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");
        int N = Integer.parseInt(token[0]);
        int K = Integer.parseInt(token[1]);

        int numer = factorial(N);
        int denom = factorial(K) * factorial(N - K) % P;
        System.out.println(numer * pow(denom, P - 2) % P);
    }

    public static int factorial(int N) {

        int fac = 1;
        while (N > 1) {
            fac = (fac * N) % P;
            N--;
        }
        return fac;
    }

    public static int pow(int base, int expo) {

        if (expo == 1) return base % P;

        int tmp = pow(base, expo / 2);
        if (expo % 2 == 1) return (tmp * tmp % P) * base % P;
        return tmp * tmp % P;
    }
}
