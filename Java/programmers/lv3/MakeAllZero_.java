package programmers.lv3;

import java.util.*;

class node implements Comparable<node> {
    int idx;
    node left;
    node right;
    long data;
    node(int idx, long data) {
        this.idx = idx;
        this.left = null;
        this.right = null;
        this.data = data;
    }

    @Override
    public int compareTo(node o) {
        if (this.idx < o.idx) return -1;
        else if (this.idx == o.idx) return 0;
        else return 1;
    }

    public void add(node nde) {
        if (this.left == null) this.left = nde;
        else if (this.right == null) this.right = nde;
    }
}

public class MakeAllZero_ {

    public long solution(int[] a, int[][] edges) {

        TreeSet<node> tree = new TreeSet<>();
        long[] b = Arrays.stream(a).mapToLong(i -> i).toArray();
        if (isAllZero(b)) return 0;
        makeTree(tree, b, edges);
        long answer = bfs(tree, b, edges);
        return answer;
    }

    public boolean isAllZero(long[] b) {
        for (int i = 0; i < b.length; i++) {
            if (b[i] != 0) return false;
        }
        return true;
    }

    public void makeTree(TreeSet<node> tree, long[] b, int[][] edges) {
        boolean flag;
        boolean[] used = new boolean[b.length];
        for (int i = 0; i < b.length; i++) {
            node nde = new node(i, b[i]);
            flag = false;
            for (int j = 0; j < edges.length; j++) {
                if (edges[j][0] == i || edges[j][1] == i) {
                    if (!used[edges[j][0]] && edges[j][0] != i) {
                        if (tree.contains(new node(edges[j][0], b[edges[j][0]]))) continue;
                        nde.add(new node(edges[j][0], b[edges[j][0]]));
                        used[edges[j][0]] = true;
                        flag = true;
                    }
                    else if (!used[edges[j][1]] && edges[j][1] != i) {
                        if (tree.contains(new node(edges[j][1], b[edges[j][1]]))) continue;
                        nde.add(new node(edges[j][1], b[edges[j][1]]));
                        used[edges[j][1]] = true;
                        flag = true;
                    }
                }
            }
            if (!flag) continue;
            tree.add(nde);
            used[i] = true;
        }

    }

    public long bfs(TreeSet<node> tree, long[] b, int[][] edges) {

        node front = null;
        int sum = 0;
        long tmp = 0;
        long cnt = 0;
        boolean[] used = new boolean[b.length];
        while (!tree.isEmpty()) {
            front = tree.pollLast();
            tmp = front.data;
            used[front.idx] = true;
            if (front.left != null) {
                while (!used[front.left.idx] && front.left.data != 0) {
                    if (front.left.data < 0) {
                        front.left.data++;
                        front.data--;
                    } else {
                        front.left.data--;
                        front.data++;
                    }
                }
                used[front.left.idx] = true;
            }
            if (front.right != null) {
                while (front.right != null && !used[front.right.idx] && front.right.data != 0) {
                    if (front.right.data < 0) {
                        front.right.data++;
                        front.data--;
                    } else {
                        front.right.data--;
                        front.data++;
                    }
                }
                used[front.right.idx] = true;
            }
            sum += front.data;
            cnt += sum - tmp;
        }
        if (sum == 0 && cnt != 0) return cnt;
        return -1;
    }
}

class test24 {

    public static void main(String[] args) {

        int[] a = { -2, 8, -5, -5, -3, 0, 5, 2 };
        int[][] edges = {
                { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 2, 6 }, { 2, 7 }
        };
        MakeAllZero_ makeAllZero = new MakeAllZero_();
        long result = makeAllZero.solution(a, edges);
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