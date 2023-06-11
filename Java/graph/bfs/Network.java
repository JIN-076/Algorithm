package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Network {

    /**
     * 재귀 호출을 이용한 풀이 -> DFS
     */

    public int solution2(int n, int[][] computers) {

        int answer = 0;
        boolean[] used = new boolean[n];
        answer = isFinish(used, n, computers);
        return answer;
    }

    public int isFinish(boolean[] used, int n, int[][] computers) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                answer++;
                dfs(i, used, n, computers);
            }
        }
        return answer;
    }

    public void dfs(int idx, boolean[] used, int n, int[][] computers) {
        used[idx] = true;
        for (int i = 0; i < computers[idx].length; i++) {
            if (!used[i] && computers[idx][i] == 1 && computers[i][idx] == 1) {
                dfs(i, used, n, computers);
            }
        }
    }

    /**
     * Queue를 이용한 풀이 -> BFS
     */

    public static int answer = 0;

    public int solution(int n, int[][] computers) {

        boolean[] used = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        isFinish(q, used, n, computers);
        return answer;
    }

    public void isFinish(Queue<Integer> q, boolean[] used, int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                answer++;
                bfs(i, q, used, n, computers);
            }
        }
    }

    public void bfs(int idx, Queue<Integer> q, boolean[] used, int n, int[][] computers) {
        used[idx] = true;
        q.add(idx);
        while (!q.isEmpty()) {
            int front = q.poll();
            for (int i = 0; i < computers[idx].length; i++) {
                if (used[i]) continue;
                if (computers[front][i] == 1 && computers[i][front] == 1) {
                    q.add(i);
                    used[i] = true;
                }
            }
        }
    }
}

class test19 {

    public static void main(String[] args) {

        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 0}
        };
        Network network = new Network();
        int result1 = network.solution(n, computers);
        int result2 = network.solution2(n, computers);
        System.out.println(result1);
        System.out.println(result2);
    }
}
