package com.pandeyar.datastructure.linkedlist;

import static com.pandeyar.datastructure.linkedlist.LinkedList.Node;


public class LinkedListStartNodeofLoop {

    public static Node findStartNodeOfTheLoop(Node head) {
        Node fastPtr = head;
        Node slowPtr = head;
        boolean loopExists = false;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
            }

        }
        if (loopExists) {
            slowPtr = head;

            while (slowPtr != fastPtr) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }


        } else {
            System.out.println("Loop does not exists");
            slowPtr = null;
        }
        return slowPtr;
    }


    public static void main(String[] args) {
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
        list.addToTheLast(loopNode);

        Node startNode = findStartNodeOfTheLoop(head);
        if (startNode != null)
            System.out.println("start Node of loop is " + startNode.value);
    }
}
