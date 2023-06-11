package backtracking;

import java.util.HashMap;
import java.util.Scanner;

public class Sitdown {
    public int solution(int r, int c, String[] teams) {

        int[][] office = new int[r][c];
        boolean[][] isSit = new boolean[teams.length][];
        String[][] worker = new String[teams.length][];

        for (int i = 0; i < teams.length; i++) {
            worker[i] = teams[i].split(" ");
            isSit[i] = new boolean[worker[i].length];
            for (int j = 0; j < worker[i].length; j++) {
                isSit[i][j] = false;
            }
        }

        return backtracking(r, c, 0, 0, office, isSit, worker);
    }

    public int backtracking(int r, int c, int curx, int cury, int[][] office, boolean[][] isSit, String[][] worker) {

        if (curx < r - 1 && cury == c) return backtracking(r, c, curx + 1, 0, office, isSit, worker);
        else if (curx == r - 1 && cury == c) return 1;

        int answer;
        int teamUp = findUp(curx, cury, office);
        int teamLeft = findLeft(curx, cury, office);
        answer = 0;

        for (int i = 0; i < worker.length; i++) {
            if (i == teamUp || i == teamLeft) continue;
            office[curx][cury] = i;
            for (int j = 0; j < worker[i].length; j++) {
                if (isSit[i][j]) continue;
                isSit[i][j] = true;
                answer += backtracking(r, c, curx, cury + 1, office, isSit, worker);
                System.out.println("curx: " + curx + ", cury: " + cury + ", answer: " + answer);
                isSit[i][j] = false;
            }
            office[curx][cury] = -1;
        }
        return answer;
    }

    public int findUp(int curx, int cury, int[][] office) {
        if (curx - 1 < 0) return -1;
        return office[curx - 1][cury];
    }

    public int findLeft(int curx, int cury, int[][] office) {
        if (cury - 1 < 0) return -1;
        return office[curx][cury - 1];
    }

}

class Main {
    public static void main(String[] args) {
        int r = 1;
        int c = 2;
        String[] teams = {"A", "B"};
        //String[] teams = {"Willy Andy", "Green Ethan", "Paul", "Steve"};
        Sitdown sitdown = new Sitdown();
        int answer = 0;
        answer = sitdown.solution(r, c, teams);
        System.out.println(answer); // 224
    }
}
