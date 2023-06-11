package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class WordTranslation {

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        if (!isExist(target, words)) return answer;

        Queue<Pair> q = new LinkedList<>();
        boolean[] used = new boolean[words.length];
        answer = bfs(begin, q, target, words, used);

        return answer;
    }

    public boolean isExist(String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) return true;
        }
        return false;
    }

    public boolean isValid(String base, String word) {
        int cnt = 0;
        for (int i = 0; i < word.length(); i++) {
            if (base.charAt(i) != word.charAt(i)) cnt++;
            if (cnt > 1) return false;
        }
        return true;
    }

    public int bfs(String base, Queue<Pair> q, String target, String[] words, boolean[] used) {
        q.add(new Pair(base, 0));
        while (!q.isEmpty()) {
            Pair front = q.poll();
            String str = front.base;
            front.cnt++;
            if (str.equals(target)) return front.cnt - 1;
            for (int i = 0; i < words.length; i++) {
                if (used[i]) continue;
                if (!isValid(str, words[i])) continue;
                used[i] = true;
                q.add(new Pair(words[i], front.cnt));
            }
        }
        return 0;
    }
}

class Pair {
    String base;
    int cnt;

    Pair(String base, int cnt) {
        this.base = base;
        this.cnt = cnt;
    }
}

class test20 {

    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = {
                "hot", "dot", "dog", "lot", "log", "cog"
        };
        WordTranslation wordTranslation = new WordTranslation();
        System.out.println(wordTranslation.solution(begin, target, words));
    }
}
