package trees;

public class TestBinaryTree {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(5);
        binaryTree.insert(binaryTree.getRoot(), 1);
        binaryTree.insert(binaryTree.getRoot(), 3);
        binaryTree.insert(binaryTree.getRoot(), 8);
        binaryTree.inOrder(binaryTree.getRoot());
    }

}
