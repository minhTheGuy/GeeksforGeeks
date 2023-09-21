package linkedlist;

public class Node<E> {
    private E element;
    private Node<E> next;

    public Node(E data) {
        element = data;
        next = null;
    }
    public Node(E data, Node<E> next) {
        element = data;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setElement(E newElem) {
        element = newElem;
    }
    public void setNext(Node<E> newNode) {
        next = newNode;
    }
}
