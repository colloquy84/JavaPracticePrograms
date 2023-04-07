package com.pandeyar.datastructure.linkedlist;

public class ReverseLinkedListWithRecurrsion {

    public static LinkedList.Node reverseLinkedList(LinkedList.Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        LinkedList.Node remaining = reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;
        return remaining;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // Creating a linked list
        LinkedList.Node head=new LinkedList.Node(5);
        list.addToTheLast(head);
        list.addToTheLast(new LinkedList.Node(6));
        list.addToTheLast(new LinkedList.Node(7));
        list.addToTheLast(new LinkedList.Node(1));
        list.addToTheLast(new LinkedList.Node(2));

        list.printList(head);
        //Reversing LinkedList
        LinkedList.Node reverseHead=reverseLinkedList(head);
        System.out.println("After reversing");
        list.printList(reverseHead);

    }
}
