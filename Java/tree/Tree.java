package tree;

import java.util.Vector;

public class Tree {

    public class Node {
        Object data;
        Node parent;
        Vector<Node> child;
    }

    public void printTraversal(Node root) {
        System.out.println(root.data);
        for (int i = 0; i < root.child.size(); i++) {
            printTraversal(root.child.get(i));
        }
    }

    public int getHeight(Node root) {
        int height = 0;
        for (int i = 0; i < root.child.size(); i++) {
            height = Math.max(height, getHeight(root.child.get(i)) + 1);
        }
        return height;
    }
}
