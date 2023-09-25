package trees;

public class Node { // this is the node which contains 2 other node or leaf

    int element;
    private Node leftNode;
    private Node rightNode;
    public Node(int data) {
        element = data;
        leftNode = null;
        rightNode = null;
    }
    // Getter and Setter
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
