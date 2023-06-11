package backjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class printerQueue {

    public static int counter = 0;

    public int solution(int N, int M, int[] Priority) {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < Priority.length; i++) {
            q1.add(Priority[i]);
            q2.add(i);
        }

        int front1 = -1;
        int front2 = -1;
        counter = 0;

        while (!q1.isEmpty() && !q2.isEmpty()) {
            front1 = q1.poll();
            front2 = q2.poll();
            if (!q1.isEmpty() && !q2.isEmpty() && front1 < Collections.max(q1)) {
                q1.add(front1);
                q2.add(front2);
                continue;
            }
            ++counter;
            if (front2 == M) break;
        }
        return counter;
    }
}

class silver1 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(bufferedReader.readLine());

        for (int t = 0; t < test_case; t++) {
            String[] token = bufferedReader.readLine().split("\\s");
            int N = Integer.parseInt(token[0]);
            int M = Integer.parseInt(token[1]);

            token = bufferedReader.readLine().split("\\s");
            int[] Priority = Arrays.stream(token).mapToInt(Integer::parseInt).toArray();
            printerQueue printerQueue = new printerQueue();
            System.out.println(printerQueue.solution(N, M, Priority));
        }
    }
}
