package com.pandeyar.datastructure.linkedlist;

import static com.pandeyar.datastructure.linkedlist.LinkedList.Node;


public class LinkedListeDetectLoop {

    public static boolean ifLoopExists(Node head) {
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr)
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("No lopp exists");
        noLoopExists();
        System.out.println("\n***********************\n");
        System.out.println("Loop exists");
        loopExists();

    }

    private static void noLoopExists() {
        LinkedList list = new LinkedList();
        // Creating a linked list

        Node head = new Node(5);
        list.addToTheLast(head);
        list.addToTheLast(new Node(6));
        list.addToTheLast(new Node(7));
        list.addToTheLast(new Node(1));
        list.addToTheLast(new Node(2));


        list.printList(head);

        // Test if loop existed or not
        System.out.println("Loop existed-->" + ifLoopExists(head));
    }

    private static void loopExists() {
        LinkedList list = new LinkedList();
        // Creating a linked list
        Node loopNode = new Node(7);
        Node head = new Node(5);
        list.addToTheLast(head);
        list.addToTheLast(new Node(6));
        list.addToTheLast(loopNode);
        list.addToTheLast(new Node(1));
        list.addToTheLast(new Node(2));

        list.printList(head);
        // creating a loop
        list.addToTheLast(loopNode);
        // Test if loop existed or not
        System.out.println("Loop existed-->" + ifLoopExists(head));
    }
}
