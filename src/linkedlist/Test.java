package linkedlist;

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
        System.out.println(llist.countItemAppeared_Recursive(9, llist.getHead()));
    }
}
