package programmers.lv0;

import java.util.HashMap;
import java.lang.String;

public class 옹알이1 {

    public int solution1(String[] babbling) {
        int answer = 0;
        for (int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replace("aya", " ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ma", " ");
            babbling[i] = babbling[i].replace(" ", "");

            if (babbling[i].length() == 0) answer++;
        }
        return answer;
    }

    public int solution2(String[] babbling) {
        HashMap<Character, String> words = new HashMap<>() {
            {
                put('a', "aya");
                put('y', "ye");
                put('w', "woo");
                put('m', "ma");
            }
        };
        int answer = 0;

        for (String str : babbling) {
            char prev = '\u0000';
            int i = 0;
            for (; i < str.length();) {
                if (prev == str.charAt(i)) break;
                String word = words.getOrDefault(str.charAt(i), "");
                if (word.equals("")) break;
                String substr = str.substring(
                        i, Math.min(str.length(), i + word.length())
                );

                if (word.equals(substr)) {
                    prev = str.charAt(i);
                    i += word.length();
                } else break;
            }
            if (i == str.length()) answer++;
        }

        return answer;
    }

}

class Main {

    public static void main(String[] args) {
        String[] babbling = new String[5];
        babbling[0] = "aya";
        babbling[1] = "yee";
        babbling[2] = "u";
        babbling[3] = "maa";
        babbling[4] = "wyeoo";

        옹알이1 prob = new 옹알이1();
        System.out.println(prob.solution1(babbling));
        System.out.println(prob.solution2(babbling));
    }
}
