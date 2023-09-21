package linkedlist;

import java.util.NoSuchElementException;
import java.util.Stack;

public class MyLinkedList<E> {
    private Node<E> head;
    private int num_nodes;

    public MyLinkedList() {
        head = null;
        num_nodes = 0;
    }

    public Node<E> getHead() {
        return head;
    }

    public void addFirst(E item) {
        head = new Node<E>(item, head);
        ++num_nodes;
    }

    public void addLast(E item) {
        if (head == null) {
            addFirst(item);
            return;
        }
        Node<E> tmp = head;
        while(tmp.getNext() != null) tmp = tmp.getNext();
        tmp.setNext(new Node<E>(item, tmp.getNext()));
        ++num_nodes;
    }

    public E removeFirst() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        Node<E> tmp = head;
        head = head.getNext();
        --num_nodes;
        return tmp.getElement();
    }

    public boolean contains(E item) {
        if (head == null) {
            return false;
        }
        Node<E> tmp = head;
        while (tmp != null) {
            if (tmp.getElement() == item) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return num_nodes;
    }

    public boolean isEmpty() {
        return num_nodes == 0;
    }

    public void swap(Node<E> a, Node<E> b) {
        if (a == b) {
            return;
        }
        Node<E> prevA = null;
        Node<E> currA = head;

        while (currA != null) {
            if (currA == a) break;
            prevA = currA;
            currA = currA.getNext();
        }
        Node<E> prevB = null;
        Node<E> currB = head;
        while (currB != null) {
            if (currB == b) break;
            prevB = currB;
            currB = currB.getNext();
        }
        if (currB == null || currA == null) return;
        if (prevA != null) prevA.setNext(currB);
        else head = currB;
        if (prevB != null) prevB.setNext(currA);
        else head = currA;
        Node<E> tmp = currA;
        currA.setNext(currB.getNext());
        currB.setNext(tmp);
    }

    public void sort() throws NoSuchElementException {
        if (head == null) throw new NoSuchElementException("List is empty");
        for (Node<E> tmp1 = head; tmp1 != null; tmp1 = tmp1.getNext())
            for (Node<E> tmp2 = tmp1.getNext(); tmp2 != null; tmp2 = tmp2.getNext()) {
                if ((Integer) tmp1.getElement() > (Integer) tmp2.getElement()) {
                    E tmp = tmp1.getElement();
                    tmp1.setElement(tmp2.getElement());
                    tmp2.setElement(tmp);
                }
            }
    }
    public void reverse() throws NoSuchElementException{
        if (head == null) throw new NoSuchElementException();
        Stack<Node<E>> stack = new Stack<Node<E>>();
        Node<E> tmp = head;
        while(tmp != null) {
            stack.push(tmp);
            tmp = tmp.getNext();
        }
        head = stack.pop();
        tmp = head;
        while (!stack.isEmpty()) {
            tmp.setNext(stack.pop());
            tmp = tmp.getNext();
        }
    }
    public int countItemAppeared(E item) {
        if (head == null) return 0;
        Node<E> tmp = head;
        int num = 0;
        while (tmp != null) {
            if (tmp.getElement().equals(item))
                ++num;
            tmp = tmp.getNext();
        }
        return num;
    }

    public int countItemAppeared_Recursive(E item, Node<E> next) {
        if (next == null) return 0;
        if (item.equals(next)) {
            return countItemAppeared_Recursive(item, next.getNext()) + 1;
        }
        else return countItemAppeared_Recursive(item, next.getNext());
    }
    public void print() {
        if (head == null) return;
        Node<E> tmp = head;
        System.out.print(tmp.getElement());
        tmp = tmp.getNext();
        while (tmp != null) {
            if (tmp.getNext() == head) {
                System.out.println(" -> " + tmp.getElement());
                break;
            }
            System.out.print(" -> " + tmp.getElement());
            tmp = tmp.getNext();
        }
    }
}
