package com.pandeyar.datastructure.tree.binarytree;


// tree.java
// demonstrates binary tree
// to run this program: C>java TreeApp
public class BinaryNode {
    public int iData; // data item (key)

    public double dData;// data item

    public BinaryNode leftChild; // this node’s left child // this node’s right child

    public BinaryNode rightChild; // display ourself


    public void displayNode() {
        System.out.print("{");
        System.out.print(iData);
        System.out.print(", ");
        System.out.print(dData);
        System.out.print("}");
    }
}
