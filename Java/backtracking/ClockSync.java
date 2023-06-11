package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class ClockSync {

    public static int INF = 9999;
    public static int SWITCHES = 10;
    public static int CLOCKS = 16;
    public static char[][] linked = {
        "xxx.............".toCharArray(),
        "...x...x.x.x....".toCharArray(),
        "....x.....x...xx".toCharArray(),
        "x...xxxx........".toCharArray(),
        "......xxx.x.x...".toCharArray(),
        "x.x...........xx".toCharArray(),
        "...x..........xx".toCharArray(),
        "....xx.x......xx".toCharArray(),
        ".xxxxx..........".toCharArray(),
        "...xxx...x...x..".toCharArray()
    };

    public void print() {
        for (int i = 0; i < linked.length; i++) {
            for (int j = 0; j < linked[i].length; j++) {
                System.out.print(linked[i][j]);
            }
            System.out.println();
        }
    }

    public boolean areAligned(int[] clocks) {
        for (int i : clocks) if (i != 12) return false;
        return true;
    }

    public void push(int[] clocks, int swtch) {
        for (int clock = 0; clock < CLOCKS; clock++) {
            if (linked[swtch][clock] == 'x') {
                clocks[clock] += 3;
                if (clocks[clock] == 15) clocks[clock] = 3;
            }
        }
    }

    public int solve(int[] clocks, int swtch) {
        if (swtch == SWITCHES) return areAligned(clocks) ? 0 : INF;
        int ret = INF;
        for (int cnt = 0; cnt < 4; cnt++) {
            ret = Math.min(ret, cnt + solve(clocks, swtch + 1));
            push(clocks, swtch);
        }
        return ret;
    }

    /**
     * 10개의 스위치에 대해 10조각으로 분할
     * 한 조각에서 한 스위치를 누를 횟수를 정함
     */

    public int solution(int[] clocks) {
        int ret = solve(clocks, 0);
        if (ret == INF) return -1;
        return ret;
    }
}

class test16 {

    public static int[] parse(String[] tokens) {
        int[] clock = new int[16];
        for (int i = 0; i < tokens.length; i++)
            clock[i] = Integer.parseInt(tokens[i]);
        return clock;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] clocks;
        String line;
        line = bufferedReader.readLine();
        String[] tokens = line.split("\\s");
        clocks = parse(tokens);
        ClockSync clockSync = new ClockSync();
        int ret = clockSync.solution(clocks);
        System.out.println(ret);
    }
}
