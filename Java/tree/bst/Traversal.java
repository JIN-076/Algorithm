package tree.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tree.bst.Node;

public class Traversal {

    public int tc;
    public int node;
    public List<Integer> pre;
    public List<Integer> in;


    public Traversal(int tc, int node, List<Integer> pre, List<Integer> in) {
        this.tc = tc;
        this.node = node;
        this.pre = pre;
        this.in = in;
    }

    public int find(List<Integer> order, int root) {
        int size = 0;
        for (int i = 0; i < order.size(); i++) {
            if (order.get(i) != root) size++;
            else return size;
        }
        return size;
    }

    public List<Integer> split(List<Integer> order, int begin, int end) {
        List<Integer> sub = order.subList(begin, end);
        return sub;
    }

    public void postOrder(List<Integer> pre, List<Integer> in) {
        int N = pre.size();
        if (pre.isEmpty()) return;
        int root = pre.get(0);
        int leftSub = find(in, root);
        int rightSub = N - leftSub - 1;
        postOrder(split(pre, 1, leftSub + 1), split(in, 0, leftSub));
        postOrder(split(pre, leftSub + 1, N), split(in, leftSub + 1, N));
        System.out.print(root + " ");
    }

    public void printTraversal(List<Integer> order) {
        for (int i = 0; i < order.size(); i++) {
            if (i == order.size() - 1) {
                System.out.print(order.get(i));
            } else {
                System.out.print(order.get(i) + " ");
            }
        }
    }

}

class Main {
    public static void main(String[] args) {
        int tc;
        int node;
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        tc = scanner.nextInt();
        node = scanner.nextInt();
        while (tc-- > 0) {
            for (int i = 0; i < node; i++) {
                pre.add(scanner.nextInt());
            }

            for (int i = 0; i < node; i++) {
                in.add(scanner.nextInt());
            }
        }
        Traversal traversal = new Traversal(tc, node, pre, in);
        traversal.postOrder(pre, in);
    }
}
