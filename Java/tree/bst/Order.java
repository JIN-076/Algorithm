package tree.bst;

public class Order {

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}

class Test {
    public static void main(String[] args) {
        Order order = new Order();
        Node nodeA = new Node(27);
        Node nodeB = new Node(16);
        Node nodeC = new Node(54);
        Node nodeD = new Node(9);
        Node nodeE = new Node(12);
        Node nodeF = new Node(36);
        Node nodeG = new Node(72);

        nodeA.addLeft(nodeB);
        nodeA.addRight(nodeC);
        nodeB.addLeft(nodeD);
        nodeD.addRight(nodeE);
        nodeC.addLeft(nodeF);
        nodeC.addRight(nodeG);

        order.preOrder(nodeA);
        System.out.println();
        order.inOrder(nodeA);
        System.out.println();
        order.postOrder(nodeA);
    }
}
