package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Node root; // The root of Binary Tree
    public BinaryTree() {
        root = null;
    } //Constructor

    public BinaryTree(int root) {
        this.root = new Node(root);
    } //Constructor which initialize the root value
    public Node getRoot() {
        return root;
    }
    public void insert(Node temp, int item) {
        if(temp == null) { // If root is not exists, we create root
            temp = new Node(item);
            return;
        }

        Queue<Node> q = new LinkedList<Node>(); // We use Queue to remember which node we will check if there's null child of parent node
        q.add(temp);
        while (!q.isEmpty()) {
            Node peek = q.peek();
            q.remove();
            if (peek.getLeftNode() == null) { // We check the left Node first then the right Node
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
        if (tmp == null) return; // Base case
        inOrder(tmp.getLeftNode()); // recursively reach left Node -> left leaf first and pop the method
        System.out.print(tmp.getElement() + " "); //print the current node in the current method
        inOrder(tmp.getRightNode()); // recursively reach right Node -> right left and pop the method
    }
}
