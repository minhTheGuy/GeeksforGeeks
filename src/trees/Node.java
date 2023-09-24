package trees;

public class Node {

    int element;
    private Node leftNode;
    private Node rightNode;
    public Node(int data) {
        element = data;
        leftNode = null;
        rightNode = null;
    }

    public int getElement() {
        return this.element;
    }
    public Node getLeftNode() {
        return leftNode;
    }
    public Node getRightNode() {
        return rightNode;
    }
    public void setElement(int element) {
        this.element = element;
    }
    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }
    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
