package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Node root;
    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int root) {
        this.root = new Node(root);
    }
    public Node getRoot() {
        return root;
    }
    public void insert(Node temp, int item) {
        if(temp == null) {
            temp = new Node(item);
            return;
        }

        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);
        while (!q.isEmpty()) {
            Node peek = q.peek();
            q.remove();
            if (peek.getLeftNode() == null) {
                peek.setLeftNode(new Node(item));
                break;
            }
            else {
                q.add(peek.getLeftNode());
            }

            if (peek.getRightNode() == null) {
                peek.setRightNode(new Node(item));
                break;
            }
            else {
                q.add(peek.getRightNode());
            }
        }

    }

    public void inOrder(Node tmp) {
        if (tmp == null) return;
        inOrder(tmp.getLeftNode());
        System.out.print(tmp.getElement() + " ");
        inOrder(tmp.getRightNode());
    }
}
