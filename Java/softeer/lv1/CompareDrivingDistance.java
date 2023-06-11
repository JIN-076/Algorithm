package softeer.lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompareDrivingDistance {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String[] token = line.split("\\s");
        int A = Integer.parseInt(token[0]);
        int B = Integer.parseInt(token[1]);
        if (A > B) System.out.println("A");
        else if (A == B) System.out.println("same");
        else System.out.println("B");
    }
}

