package programmers.lv3;

import java.util.Arrays;
import java.util.HashMap;

public class sellToothBrush {

    public static String[] enrolls;
    public static String[] referrals;
    public static int[] amounts;
    public static HashMap<String, Integer> enrollMap = new HashMap<>();
    public static HashMap<Integer, String> referralMap = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        enrolls = enroll;
        referrals = referral;
        amounts = amount;

        parse();

        int[] answer = new int[enrolls.length];

        for (int i = 0; i < seller.length; i++) {
            profit(seller[i], answer, true, amounts[i] * 100);
        }

        return answer;
    }

    public void parse() {
        for (int i = 0; i < enrolls.length; i++) {
            enrollMap.put(enrolls[i], i);
        }

        for (int i = 0; i < referrals.length; i++) {
            referralMap.put(i, referrals[i]);
        }
    }

    public void profit(String salesman, int[] answer, boolean flag, int money) {

        if (salesman.equals("-") || !flag) {
            return;
        }

        int myIdx = findIdx(salesman);
        String recommender = findRecommender(myIdx);

        int tenPercent = money / 10;
        if (tenPercent < 1) {
            answer[myIdx] += money;
            return;
        } else {
            answer[myIdx] += money - tenPercent;
            profit(recommender, answer, true, tenPercent);
        }
    }

    public int findIdx(String salesman) {
        return enrollMap.getOrDefault(salesman, -1);
    }

    public String findRecommender(int idx) {
        return referralMap.get(idx);
    }
}

class exam3 {

    public static void main(String[] args) {

        String[] enroll = {
                "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"
        };

        String[] referral = {
                "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"
        };

        String[] seller = {
                "young", "john", "tod", "emily", "mary"
        };

        int[] amount = {
                12, 4, 2, 5, 10
        };

        sellToothBrush sellToothBrush = new sellToothBrush();
        int[] answer = sellToothBrush.solution(enroll, referral, seller, amount);
        Arrays.stream(answer).forEach(elem -> System.out.print(elem + " "));
    }
}
