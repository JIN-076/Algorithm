package softeer.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Commute {

    public static Set<Integer> s1 = new HashSet<>();
    public static Set<Integer> s2 = new HashSet<>();
    public static Set<Integer> s3 = new HashSet<>();
    public static Set<Integer> s4 = new HashSet<>();

    public static void dfs(int start, int end, Set<Integer> set, ArrayList<Integer>[] list, boolean[] visited) {
        if (start == end && end != -1) return;
        for (int i = 0; i < list[start].size(); i++) {
            int next = list[start].get(i);
            if (visited[next - 1]) continue;
            visited[next - 1] = true;
            set.add(next);
            dfs(next, end, set, list, visited);
        }
        return;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] token = bufferedReader.readLine().split("\\s");

        int N = Integer.parseInt(token[0]);
        int M = Integer.parseInt(token[1]);

        ArrayList<Integer>[] forward = new ArrayList[M];
        ArrayList<Integer>[] reverse = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            forward[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            token = bufferedReader.readLine().split("\\s");
            forward[Integer.parseInt(token[0])].add(Integer.parseInt(token[1]));
            reverse[Integer.parseInt(token[1])].add(Integer.parseInt(token[0]));
        }

        token = bufferedReader.readLine().split("\\s");
        int S = Integer.parseInt(token[0]);
        int T = Integer.parseInt(token[1]);

        /**
         * forward DFS
         * S에서 T로 도달하기 위한 정점들을 찾는 DFS
         * 1. 만약 T에 도달했다면, T에 도달한 후에 탐색할 수 있는 정점들은 탐색하지 않음.
         * 2. T에 도달하기 위해 거치는 정점은 아니지만, 탐색하는 과정에서 거치게 되는 정점이 저장됨.
         *
         * reverse DFS
         * T에 도달할 수 있는 정점들을 찾는 DFS
         * 1. T에 도달할 수 있는 정점들을 탐색함.
         * 2. forward DFS에서, 탐색하는 과정에서 거치게 되는 정점을 걸러냄.
         */

        dfs(S, T, s1, forward, new boolean[N]);
        dfs(T, -1, s2, reverse, new boolean[N]);

        s1.retainAll(s2);

        dfs(T, S, s3, forward, new boolean[N]);
        dfs(S, -1, s4, reverse, new boolean[N]);

        s3.retainAll(s4);
        s1.retainAll(s3);

        int answer = s1.size();

        if (s1.contains(S)) answer--;
        if (s1.contains(T)) answer--;

        System.out.println(answer);
    }
}
