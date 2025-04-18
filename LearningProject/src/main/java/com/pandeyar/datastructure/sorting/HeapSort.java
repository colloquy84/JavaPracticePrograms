package com.pandeyar.datastructure.sorting;

import java.util.Arrays;

/**
 * Represent array as complete binary tree.
 * Left child will be at 2*i+1 th location
 * Right child will be at 2*i+2 th location.
 * Build a heap.
 * All the leaf nodes already satisfy heap property, so we don’t need to heapify them.
 * Last leaf node will be present at (n-1)th location, so parent of it will be at (n-1)/2 th location, hence (n-1)/2 will be location of last non leaf node.
 * Iterate over non leaf nodes and heapify the elements.
 * After building a heap, max element will be at root of the heap. We will exchange it with (n-1)th location, so largest element will be at proper place and remove it from the heap by reducing size of n.
 * When you exchange largest element, it may disturb max heap property, so you need to again heapify it.
 * Once you do above steps until no elements left in heap, you will get sorted array in the end.
 */

public class HeapSort {
    public static void buildheap(int[] arr) {

        /*
         * As last non leaf node will be at (arr.length-1)/2
         * so we will start from this location for heapifying the elements
         * */
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, i, arr.length - 1);
        }
    }

    public static void heapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max;
        if (left <= size && arr[left] > arr[i]) {
            max = left;
        } else {
            max = i;
        }

        if (right <= size && arr[right] > arr[max]) {
            max = right;
        }
        // If max is not current node, exchange it with max of left and right child
        if (max != i) {
            exchange(arr, i, max);
            heapify(arr, max, size);
        }
    }

    public static void exchange(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static int[] heapSort(int[] arr) {

        buildheap(arr);
        int sizeOfHeap = arr.length - 1;
        for (int i = sizeOfHeap; i > 0; i--) {
            exchange(arr, 0, i);
            sizeOfHeap = sizeOfHeap - 1;
            heapify(arr, 0, sizeOfHeap);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 16, 19, 3, 5};
        System.out.println("Before Heap Sort : ");
        System.out.println(Arrays.toString(arr));
        arr = heapSort(arr);
        System.out.println("=====================");
        System.out.println("After Heap Sort : ");
        System.out.println(Arrays.toString(arr));
    }
}
