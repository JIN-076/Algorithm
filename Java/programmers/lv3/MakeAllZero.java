package programmers.lv3;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MakeAllZero {

    long answer;
    boolean[] visited;
    long[] b;
    ArrayList<Integer>[] tree;

    public long solution(int[] a, int[][] edges) {
        this.answer = 0;
        this.visited = new boolean[a.length];
        this.b = new long[a.length];
        this.tree = new ArrayList[a.length];

        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            tree[i] = new ArrayList<>();
            b[i] = a[i];
        }

        if (sum != 0) return -1;

        for (int i = 0; i < edges.length; i++) {
            tree[edges[i][0]].add(edges[i][1]);
            tree[edges[i][1]].add(edges[i][0]);
        }

        dfs(0);

        return answer;
    }

    public long dfs(int node) {
        this.visited[node] = true;

        for (int i = 0; i < tree[node].size(); i++) {
            int next = tree[i].get(i);
            if (visited[next]) continue;
            b[node] += dfs(next);
        }

        this.answer += Math.abs(b[node]);
        return b[node];
    }
}

class test25 {

    public static void main(String[] args) {

        int[] a = { -2, 8, -5, -5, -3, 0, 5, 2 };
        int[][] edges = {
                { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 2, 6 }, { 2, 7 }
        };
        MakeAllZero makeTheAllZero = new MakeAllZero();
        long result = makeTheAllZero.solution(a, edges);
        System.out.println(result);
    }
}

/**
 * { -5, 0, 2, 1, 2 }
 * { 0, 1 }, { 3, 4 }, { 2, 3 }, { 0, 3 }
 * -> 9
 *
 * { 0, 1, 0 }
 * { 0, 1 }, { 1, 2 }
 * -> -1
 *
 * { 0, -5, 4, 0, 1 }
 * { 0, 1 }, { 1, 3 }, { 2, 3 }, { 3, 4 }
 * -> 10
 */