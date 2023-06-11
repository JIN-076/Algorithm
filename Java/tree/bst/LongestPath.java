package tree.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.nextUp;

public class LongestPath {

    public int longest;
    public int N;
    public int[] y;
    public int[] x;
    public int[] radius;

    public LongestPath(int N, int[] y, int[] x, int[] radius) {
        this.N = N;
        this.y = new int[100];
        this.x = new int[100];
        this.radius = new int[100];
    }

    public class TreeNode {
        List<TreeNode> child;
    }

    public int getHeight(TreeNode root) {
        List<Integer> heights =  new ArrayList<Integer>();
        for (int i = 0; i < root.child.size(); i++) {
            heights.add(getHeight(root.child.get(i)));
        }
        if (heights.isEmpty()) return 0;
        Collections.sort(heights);
        if (heights.size() >= 2) {
            longest = max(longest, heights.get(heights.size() - 2) + heights.get(heights.size() - 1) + 2);
        }
        return heights.get(heights.size() - 1) + 1;
    }

    int solve(TreeNode root) {
        this.longest = 0;
        int height = getHeight(root);
        return max(longest, height);
    }

    TreeNode getTree(int root) {
        TreeNode node = new TreeNode();
        for (int child = 0; child < this.N; ++child) {
            if (isChild(root, child)) {
                node.child.add(getTree(child));
            }
        }
        return node;
    }

    int sqr(int x) {
        return x * x;
    }

    int sqrDist(int a, int b) {
        return sqr(this.y[a] - this.y[b]) + sqr(this.x[a] - this.x[b]);
    }

    boolean isEnclose(int a, int b) {
        return radius[a] > radius[b] && sqrDist(a, b) < sqr(this.radius[a] - this.radius[b]);
    }

    boolean isChild(int parent, int child) {
        if (!isEnclose(parent, child)) return false;
        for (int i = 0; i < this.N; ++i) {
            if (i != parent && i != child && isEnclose(parent, i) && isEnclose(i, child))
                return false;
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        int tc;
        int N;
        int[] y = new int[100];
        int[] x = new int[100];
        int[] radius = new int[100];

        Scanner scanner = new Scanner(System.in);
        tc = scanner.nextInt();
        while (tc-- > 0) {
            N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                x[i] = scanner.nextInt();
                y[i] = scanner.nextInt();
                radius[i] = scanner.nextInt();
            }
            LongestPath longestPath = new LongestPath(N, y, x, radius);
            LongestPath.TreeNode root = longestPath.getTree(0);
            System.out.println(longestPath.solve(root));
        }

    }
}
