package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class FindPrime {

    public static StringBuffer stringBuffer = new StringBuffer();

    public int solution(String numbers) {
        int answer = 0;

        boolean[] used = new boolean[numbers.length()];
        Arrays.fill(used, false);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= numbers.length(); i++)
            answer += bruteforce(0, i, stringBuffer, used, list, numbers);
        return answer;
    }

    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i <= (int)Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public int getLength(int num) {
        int cnt = 0;
        do {
            num = num / 10;
            cnt++;
        } while (num > 0);
        return cnt;
    }

    public boolean isTwice(ArrayList<Integer> list, int num) {
        for (int i = 0; i < list.size(); i++)
            if (list.get(i) == num) return true;
        return false;
    }

    public int bruteforce(int idx, int N, StringBuffer buffer, boolean[] used, ArrayList<Integer> list, String numbers) {
        if (idx == N) {
            String str = buffer.toString();
            int num = Integer.parseInt(str);
            if (getLength(num) != N) return 0;
            if (!isTwice(list, num)) list.add(num);
            else return 0;
            if (isPrime(num)) return 1;
            else return 0;
        }

        int answer;
        answer = 0;

        for (int i = 0; i < numbers.length(); i++) {
            if (used[i]) continue;
            buffer.append(numbers.charAt(i));
            used[i] = true;
            answer += bruteforce(idx + 1, N, buffer, used, list, numbers);
            buffer.deleteCharAt(idx);
            used[i] = false;
        }
        return answer;
    }
}

class test13 {

    public static void main(String[] args) {

        String numbers = "011";
        FindPrime findPrime = new FindPrime();
        int ret = findPrime.solution(numbers);
        System.out.println(ret);
    }
}
