package com.pandeyar.datastructure.linkedlist;

public class ReverseLinkedList {

    // Reverse linkedlist using this function
    public static LinkedList.Node reverseLinkedList(LinkedList.Node currentNode) {
        // For first node, previousNode will be null
        LinkedList.Node previousNode = null;
        LinkedList.Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            // reversing the link
            currentNode.next = previousNode;
            // moving currentNode and previousNode by 1 node
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // Creating a linked list
        LinkedList.Node head = new LinkedList.Node(5);
        list.addToTheLast(head);
        list.addToTheLast(new LinkedList.Node(6));
        list.addToTheLast(new LinkedList.Node(7));
        list.addToTheLast(new LinkedList.Node(1));
        list.addToTheLast(new LinkedList.Node(2));

        list.printList(head);
        //Reversing LinkedList
        LinkedList.Node reverseHead = reverseLinkedList(head);
        System.out.println("After reversing");
        list.printList(reverseHead);

    }


}
