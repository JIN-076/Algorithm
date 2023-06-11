package softeer.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AplusB {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bufferedReader.readLine());
        String line;
        int answer;
        for (int i = 1; i <= test_case; i++) {
            line = bufferedReader.readLine();
            String[] token = line.split("\\s");
            int A = Integer.parseInt(token[0]);
            int B = Integer.parseInt(token[1]);
            answer = A + B;
            System.out.println("Case #" + i + ": " + answer);
        }
    }
}
