package linkedlist;

import java.util.HashSet;
import java.util.NoSuchElementException;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> llist = new MyLinkedList<>();
//        llist.addFirst(3);
//        llist.addFirst(0);
//        llist.addLast(7);
//        llist.addLast(5);
//        llist.addFirst(9);
//        llist.addFirst(1);
//        llist.addLast(4);
//        llist.addLast(2);
//        llist.addFirst(8);
//        llist.addLast(9);
        llist.addFirst(1);
        llist.addFirst(1);
        llist.addFirst(3);
        llist.addFirst(3);
        llist.addFirst(4);
        /*llist.sort();
        llist.print();*//*
        System.out.println(llist.countItemAppeared(9));*/
        /*System.out.println(llist.countItemAppeared_Recursive(9, llist.getHead()));
        convertSinglyToCircular(llist);
        llist.print();*/
//        llist.print();
//        System.out.println();
//        exchangeFirstAndLastNode(llist);
//        System.out.println();
//        llist.print();
//        System.out.println();
//        reverse(llist);
//        llist.print();
//        System.out.println();
//        traverseCircularLList(llist);
//        removeDuplicate(llist);
//        System.out.println();
//        llist.print();
        MyLinkedList<Integer> llist1 = new MyLinkedList<Integer>();
        llist1.addLast(8);
        llist1.addLast(9);
        llist1.addLast(10);
        llist1.addLast(11);
        llist1.addLast(12);
        MyLinkedList<Integer> llist2 = new MyLinkedList<Integer>();
        llist2.addLast(5);
        llist2.addLast(6);
        llist2.addLast(7);
        llist2.addLast(8);
        llist2.addLast(9);
//        MyLinkedList<Integer> llist3 = intersectTwoLinkedList(llist1, llist2);
//        llist3.print();
        Node<Integer> head4 = intersectTwoLinkedList_Recursive(llist1.getHead(), llist2.getHead());
        MyLinkedList<Integer> llist4 = new MyLinkedList<Integer>();
        llist4.setHead(head4);
        llist4.print();
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
    public static void reverse(MyLinkedList<Integer> ll) {
        if (ll.getHead() == null) return;
        Node<Integer> prev = null;
        Node<Integer> curr = ll.getHead();
        Node<Integer> next = null;
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        ll.setHead(prev);
    }
    public static void traverseCircularLList(MyLinkedList<Integer> ll) {
        if (ll.getHead() == null) return;
        Node<Integer> tmp = ll.getHead();
        System.out.print(tmp.getElement());
        tmp = tmp.getNext();
        while (tmp != null && tmp != ll.getHead()) {
            System.out.print(" -> " + tmp.getElement());
            tmp = tmp.getNext();
        }
    }
    public static boolean detectLoop(MyLinkedList<Integer> ll) {
        if (ll.getHead() == null) return false;
        Node<Integer> tmp = ll.getHead();
        HashSet<Node<Integer>> s = new HashSet<Node<Integer>>();
        while (tmp != null) {
            if (s.contains(tmp)) return true;
            s.add(tmp);
            tmp = tmp.getNext();
        }
        return false;
    }
    public static void removeDuplicate(MyLinkedList<Integer> ll) {
        if (ll.getHead() == null) return;
        Node<Integer> curr = ll.getHead();
        while (curr != null) {
            Node<Integer> tmp = curr;
            while (tmp != null && curr.getElement().equals(tmp.getElement())) {
                tmp = tmp.getNext();
            }
            curr.setNext(tmp);
            curr = curr.getNext();
        }
    }
    public static MyLinkedList<Integer> intersectTwoLinkedList(MyLinkedList<Integer> ll1, MyLinkedList<Integer> ll2) {
        MyLinkedList<Integer> dummy = new MyLinkedList<Integer>();
        Node<Integer> a = ll1.getHead();
        Node<Integer> b = ll2.getHead();
        if (a == null) return ll1;
        if (b == null) return ll2;
        while (a != null && b != null) {
            if (a.getElement().equals(b.getElement())) {
                dummy.addLast(a.getElement());
                a = a.getNext();
                b = b.getNext();
            }
            else if (a.getElement() < b.getElement()) {
                a = a.getNext();
            }
            else {
                b = b.getNext();
            }
        }
        return dummy;
    }
    public static Node<Integer> intersectTwoLinkedList_Recursive(Node<Integer> a, Node<Integer> b) {
        if (a == null || b == null) return null;
        if (a.getElement() > b.getElement())
            return intersectTwoLinkedList_Recursive(a, b.getNext());
        if (a.getElement() < b.getElement())
            return intersectTwoLinkedList_Recursive(a.getNext(), b);

        Node<Integer> newNode = new Node<Integer>(a.getElement());
        newNode.setNext(intersectTwoLinkedList_Recursive(a.getNext(), b.getNext()));
        return newNode;
    }
}
