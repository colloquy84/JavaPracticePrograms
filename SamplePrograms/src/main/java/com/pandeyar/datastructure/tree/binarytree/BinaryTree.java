package com.pandeyar.datastructure.tree.binarytree;

import java.util.Stack;

public class BinaryTree {
    private BinaryNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryNode find(int key) {
        BinaryNode current = root;

        while (current != null && current.iData != key) {
            if (key < current.iData)
                current = current.leftChild;
            else
                current = current.rightChild;

            if (current == null)
                return null;
        }
        return current;
    }

    public void insert(int id, double dd) {
        BinaryNode newNode = new BinaryNode();
        newNode.iData = id;
        newNode.dData = dd;

        if (root == null)
            root = newNode;
        else {
            BinaryNode current = root;
            BinaryNode parent;
            while (true) {
                parent = current;
                if (id < current.iData) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        BinaryNode current = root;
        BinaryNode parent = root;
        boolean isLeftChild = true;

        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)
                return false;
        }

        //No children simply delete it
        if (current.leftChild == null &&
                current.rightChild == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        } else if (current.rightChild == null) {        // if no right child, replace with left subtree
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        } else if (current.leftChild == null) { // if no left child, replace with right subtree
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        } else {// two children, so replace with inorder successor
            // get successor of node to delete (current)
            BinaryNode successor = getSuccessor(current);
            // connect parent of current to successor instead
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            // connect successor to current’s left child
            successor.leftChild = current.leftChild;
        } // end else two children

        return true;
    }

    // returns node with next-highest value after delNode
    // goes to right child, then right child’s left descendents
    private BinaryNode getSuccessor(BinaryNode delNode) {
        BinaryNode successorParent = delNode;
        BinaryNode successor = delNode;
        BinaryNode current = delNode.rightChild;

        while (current != null) {//go to right child until no more left children,
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public void traverse(int traverseType) {
        switch (traverseType) {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2:
                System.out.print("nInorder traversal: ");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(BinaryNode localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(BinaryNode localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(BinaryNode localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    public void displayTree() {
        Stack<BinaryNode> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (!isRowEmpty) {
            Stack<BinaryNode> localStack = new Stack<>();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) System.out.print(" ");
            while (!globalStack.isEmpty()) {
                BinaryNode temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null ||
                            temp.rightChild != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) System.out.print(" ");
            }
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }
    }
}