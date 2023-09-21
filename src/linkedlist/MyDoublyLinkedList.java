package linkedlist;

import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> {
    private DNode<E> head;
    private int num_nodes;
    public MyDoublyLinkedList() {
        head = null;
        num_nodes = 0;
    }

    public void addFirst(E item) {
        head = new DNode<E>(null, item, head);
        ++num_nodes;
    }
    public void addLast(E item) {
        DNode<E> tmp = head;
        while (tmp.getNext() != null) tmp = tmp.getNext();
        tmp.setNext(new DNode<E>(tmp, item, null));
        ++num_nodes;
    }

    public boolean contains(E item) {
        if (head == null) return false;
        DNode<E> tmp = head;
        while (tmp.getNext() != null) {
            if (tmp.getElement().equals(item)) return true;
            tmp = tmp.getNext();
        }
        return false;
    }

    public boolean isEmpty() {
        return num_nodes == 0;
    }

    public int size() {
        return num_nodes;
    }

    public E removeFirst() throws NoSuchElementException{
        if (head == null) throw new NoSuchElementException("List is empty");
        E rs = head.getElement();
        head = head.getNext();
        head.setPrev(null);
        return rs;
    }

    public void print() {
        if (head == null) return;
        DNode<E> tmp = head;
        System.out.print(tmp.getElement());
        while (tmp != null) {
            System.out.print(" -> " + tmp.getElement());
            tmp = tmp.getNext();
        }
    }
}
