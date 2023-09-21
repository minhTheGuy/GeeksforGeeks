package linkedlist;

public class DNode<E> {
    private DNode<E> prev;
    private E element;
    private DNode<E> next;
    public DNode(E item) {
        element = item;
        next = prev = null;
    }
    public DNode(DNode<E> prev, E item, DNode<E> next) {
        this.prev = prev;
        element = item;
        this.next = next;
    }
    public DNode<E> getPrev() {
        return prev;
    }
    public E getElement() {
        return element;
    }
    public DNode<E> getNext() {
        return next;
    }
    public void setPrev(DNode<E> newNode) {
        prev = newNode;
    }
    public void setElement(E item) {
        element = item;
    }
    public void setNext(DNode<E> newNode) {
        next = newNode;
    }
}
