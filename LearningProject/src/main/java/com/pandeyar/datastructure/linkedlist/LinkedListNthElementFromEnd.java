package com.pandeyar.datastructure.linkedlist;

import static com.pandeyar.datastructure.linkedlist.LinkedList.Node;

public class LinkedListNthElementFromEnd {
    public static LinkedList.Node nthFromLastNode(LinkedList.Node head, int n) {
        Node firstPtr = head;
        Node secondPtr = head;

        for (int i = 0; i < n; i++) {
            firstPtr = firstPtr.next;

        }

        while (firstPtr != null) {
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        return secondPtr;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // Creating a linked list
        Node head = new Node(5);
        list.addToTheLast(head);
        list.addToTheLast(new Node(6));
        list.addToTheLast(new Node(7));
        list.addToTheLast(new Node(1));
        list.addToTheLast(new Node(2));

        list.printList(head);
        // Finding 3rd node from end
        Node nthNodeFromLast = nthFromLastNode(head, 3);
        System.out.println("3th node from end is : " + nthNodeFromLast.value);

    }
}
