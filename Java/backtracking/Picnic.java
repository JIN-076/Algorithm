package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Picnic {

    public void solution(int N, int M, boolean[][] isFriends) {

        int result = 0;
        int[] line = new int[N];
        boolean[] taken = new boolean[N];
        Arrays.fill(line, -1);
        Arrays.fill(taken, false);
        result =  makePair(0, N, M, line, taken, isFriends);
        System.out.println(result);
    }

    public int findPair(int idx, int[] line) {
        if (idx <= 0) return -1;
        if (idx % 2 != 0) return line[idx - 1];
        return -1;
    }

    public int findPrev(int idx, int[] line) {
        if (idx <= 0) return -1;
        if (idx % 2 == 0) return line[idx - 2];
        return -1;
    }

    public int makePair(int idx, int N, int M, int[] line, boolean[] taken, boolean[][] isFriends) {
        if (idx == N) return 1;

        int answer;
        answer = 0;

        int myPair = findPair(idx, line);
        int prev = findPrev(idx, line);

        for (int friend = 0; friend < N; friend++) {
            if (taken[friend]) continue;
            if (myPair != -1 && !isFriends[myPair][friend] && !isFriends[friend][myPair]) continue;
            if (friend < myPair) continue;
            if (friend < prev) continue;
            line[idx] = friend;
            taken[friend] = true;
            answer += makePair(idx + 1, N, M, line, taken, isFriends);
            line[idx] = -1;
            taken[friend] = false;
        }
        return answer;
    }
}

class test10 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = 2;
        int M = 1;
        boolean[][] isFriends = new boolean[N][N];
        String line = bufferedReader.readLine();
        String[] tokens = line.split("\\s");
        for (int i = 0; i < tokens.length; i += 2) {
            int x = Integer.parseInt(tokens[i]);
            int y = Integer.parseInt(tokens[i + 1]);
            isFriends[x][y] = true;
            isFriends[y][x] = true;
        }
        Picnic picnic = new Picnic();
        picnic.solution(N, M, isFriends);

    }
}

/**
 * 2 1
 * 0 1
 * -> 1
 *
 * 4 6
 * 0 1 1 2 2 3 3 0 0 2 1 3
 * -> 3
 *
 * 6 10
 * 0 1 0 2 1 2 1 3 1 4 2 3 2 4 3 4 3 5 4 5
 * -> 4
 */
