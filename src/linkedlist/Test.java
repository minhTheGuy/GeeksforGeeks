package linkedlist;

import java.util.NoSuchElementException;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> llist = new MyLinkedList<>();
        llist.addFirst(3);
        llist.addFirst(0);
        llist.addLast(7);
        llist.addLast(5);
        llist.addFirst(9);
        llist.addFirst(1);
        llist.addLast(4);
        llist.addLast(2);
        llist.addFirst(8);
        llist.addLast(9);
        /*llist.sort();
        llist.print();*//*
        System.out.println(llist.countItemAppeared(9));*/
        /*System.out.println(llist.countItemAppeared_Recursive(9, llist.getHead()));
        convertSinglyToCircular(llist);
        llist.print();*/
        llist.print();
        exchangeFirstAndLastNode(llist);
        llist.print();
    }

    public static boolean isCircularLinkedList(MyLinkedList<Integer> ll) {
        if (ll.getHead() == null) return true;
        Node<Integer> tmp = ll.getHead();
        while (tmp.getNext() != null) {
            if (tmp.getNext() == ll.getHead()) return true;
            tmp = tmp.getNext();
        }
        return false;
    }
    public static void convertSinglyToCircular(MyLinkedList<Integer> ll) throws NoSuchElementException {
        Node<Integer> tmp = ll.getHead();
        if (tmp == null) throw new NoSuchElementException("List is empty");
        while (tmp.getNext() != null)
            tmp = tmp.getNext();
        tmp.setNext(ll.getHead());
    }
    public static void convertCircularToSingly(MyLinkedList<Integer> ll) throws NoSuchElementException {
        if (ll.getHead() == null) return;
        Node<Integer> curr = ll.getHead();
        while (curr != null) {
            if (curr.getNext() == ll.getHead()) {
                curr.setNext(null);
                break;
            }
            curr = curr.getNext();
        }
    }
    public static void exchangeFirstAndLastNode(MyLinkedList<Integer> ll) {
        Node<Integer> tmp = ll.getHead();
        while (tmp.getNext() != null)
            tmp = tmp.getNext();
        ll.swap(tmp, ll.getHead());
    }
}
