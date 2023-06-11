package programmers.lv0;

public class 다음에올숫자 {

    public int solution(int[] common) {
        int answer = 0;
        int idx = common.length - 1;
        int a1 = 0, g1 = 0, m1 = 0, a2 = 0, g2 = 0, m2 = 0;
        a1 = common[idx] - common[idx - 1];
        a2 = common[idx - 1] - common[idx - 2];
        if (common[idx - 1] != 0 && common[idx - 2] != 0) {
            g1 = common[idx] / common[idx - 1];
            m1 = common[idx] % common[idx - 1];
            g2 = common[idx - 1] / common[idx - 2];
            m2 = common[idx - 1] % common[idx - 2];
        }
        if (a1 == a2) answer = common[idx] + a1;
        else if (g1 == g2 && m1 == 0 && m2 == 0) answer = common[idx] * g1;
        return answer;
    }
}

class Main {

    public static void main(String[] args) {
        int[] common1 = new int[4];
        common1[0] = 1;
        common1[1] = 2;
        common1[2] = 3;
        common1[3] = 4;

        int[] common2 = new int[3];
        common2[0] = 1;
        common2[1] = 0;
        common2[2] = -1;

        다음에올숫자 prob = new 다음에올숫자();
        System.out.println(prob.solution(common2));
        //System.out.println(prob.solution(common2));
    }

}
