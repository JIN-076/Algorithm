package backtracking;

public class Carpet {

    public int[] solution(int brown, int yellow) {

        int[] answer = new int[2];

        int halfBrown = brown / 2;
        arrange(halfBrown, 1, halfBrown, yellow, answer);
        return answer;
    }

    public void arrange(int width, int height, int halfBrown, int yellow, int[] answer) {
        for (int i = 0; i < halfBrown; i++) {
            width -= 1;
            height += 1;
            if (height == 1) continue;
            if (width <= 0) break;
            if (width <= height) break;
            if (isProperYellow(width, height, halfBrown, yellow)) {
                answer[0] = width;
                answer[1] = height + 1;
                return;
            }
        }
    }

    public boolean isProperYellow(int width, int height, int halfBrown, int yellow) {
        return (width - 2) * (height - 1) == yellow;
    }

}

class test14 {

    public static void print(int[] ret) {
        System.out.print("[ ");
        for (int i = 0; i < ret.length; i++)
            System.out.print(ret[i] + " ");
        System.out.println("]");
    }

    public static void main(String[] args) {

        int brown = 24;
        int yellow = 24;
        Carpet carpet = new Carpet();
        int[] ret = carpet.solution(brown, yellow);
        print(ret);
    }
}
