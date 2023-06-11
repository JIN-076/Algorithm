package softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecretMenu {

    public static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] token = bufferedReader.readLine().split("\\s");

        int M = Integer.parseInt(token[0]);
        int N = Integer.parseInt(token[1]);
        int K = Integer.parseInt(token[2]);

        token = bufferedReader.readLine().split("\\s");
        for (int i = 0; i < token.length; i++) {
            builder.append(token[i]);
        }
        String secret = builder.toString();

        builder.setLength(0);

        token = bufferedReader.readLine().split("\\s");
        for (int i = 0; i < token.length; i++) {
            builder.append(token[i]);
        }
        String user = builder.toString();

        if (user.contains(secret)) System.out.println("secret");
        else System.out.println("normal");
    }
}
