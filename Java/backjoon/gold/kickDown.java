package backjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class kickDown {
    public static boolean[] isOverlaped;
    public static int MIN;

    public int solution(String firstGear, String secondGear) {
        return overlap(firstGear, secondGear);
    }

    public boolean canOverlap(int baseIdx, int targetIdx, String base, String target) {
        return (target.charAt(targetIdx) - '0') + (base.charAt(baseIdx) - '0') <= 3;
    }

    public int isTargetFinish(String target) {
        for (int i = 0; i < target.length(); i++) {
            if (!isOverlaped[i]) return i;
        }
        return -1;
    }

    public int baseToTarget(String base, String target) {

        int i;
        int j;
        int finished = 0;
        isOverlaped = new boolean[target.length()];
        for (i = 0; i < base.length(); i++) {
            boolean fail = false;
            if (finished == target.length()) break;
            for (j = 0; j < target.length(); j++) {
                if (i == base.length()) break;
                if (isOverlaped[j] || !canOverlap(i, j, base, target)) {
                    fail = true;
                    break;
                }
                isOverlaped[j] = true;
                finished++;
                i++;
            }
            if (fail) {
                Arrays.fill(isOverlaped, false);
                finished = 0;
                i -= j;
            }

        }
        int additional = isTargetFinish(target);
        if (additional == -1) return base.length();
        else return base.length() + target.length() - additional;
    }

    public int overlap(String firstGear, String secondGear) {
        MIN = Math.min(baseToTarget(firstGear, secondGear), baseToTarget(secondGear, firstGear));
        return MIN;
    }
}

class gold3 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstGear = bufferedReader.readLine();
        String secondGear = bufferedReader.readLine();

        kickDown kickDown = new kickDown();
        int answer = kickDown.solution(firstGear, secondGear);
        System.out.println(answer);
    }
}
