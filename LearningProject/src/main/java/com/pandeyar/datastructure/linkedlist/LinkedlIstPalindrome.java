package com.pandeyar.datastructure.linkedlist;

import static com.pandeyar.datastructure.linkedlist.LinkedList.Node;


public class LinkedlIstPalindrome {

    public static Node findMiddleNode(Node head) {
        // step 1
        Node slowPointer, fastPointer;
        slowPointer = fastPointer = head;

        while (fastPointer != null) {
            fastPointer = fastPointer.next;
            if (fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }
        }

        return slowPointer;
    }

    // Function to check if linked list is palindrome or not
    public static boolean checkPalindrome(Node head) {
        // Find middle node using slow and fast pointer
        Node middleNode = findMiddleNode(head);
        // we got head of second part
        Node secondHead = middleNode.next;
        // It is end of first part of linked list
        middleNode.next = null;
        // get reversed linked list for second part
        Node reverseSecondHead = ReverseLinkedListWithRecurrsion.reverseLinkedList(secondHead);

        while (head != null && reverseSecondHead != null) {
            if (head.value == reverseSecondHead.value) {
                head = head.next;
                reverseSecondHead = reverseSecondHead.next;
                continue;
            } else {
                return false;
            }
        }

        return true;


    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // Creating a linked list
        Node head = new Node(1);
        list.addToTheLast(head);
        list.addToTheLast(new Node(2));
        list.addToTheLast(new Node(1));
        list.addToTheLast(new Node(2));
        list.addToTheLast(new Node(1));

        list.printList(head);

        System.out.println("Linked list palidrome: " + checkPalindrome(head));
    }
}
