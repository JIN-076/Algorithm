package tree.bst;

public class Node {
    Object data;
    Node left;
    Node right;
    int size;

    public Node(Object data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.size = 0;
    }

    public void addLeft(Node node) {
        this.left = node;
        this.size++;
    }

    public void addRight(Node node) {
        this.right = node;
        this.size++;
    }

    public void deleteLeft(Node node) {
        this.left = null;
        this.size--;
    }

    public void deleteRight(Node node) {
        this.right = null;
        this.size--;
    }
}
