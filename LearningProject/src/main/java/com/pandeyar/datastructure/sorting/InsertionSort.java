package com.pandeyar.datastructure.sorting;

/**
 * Assume that left part of the array is sorted, then one by one insert each right vlue at correct place in left array
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {100, 20, 15, 30, 5, 75};
        insertionSort(arr);

    }

    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int valueToSort = arr[i];
            int prev = i - 1; // If we get smaller value than valueToSort then , we stop at that index.
            while (prev >= 0 && arr[prev] > valueToSort) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            // We will put valueToSort at that index
            arr[prev + 1] = valueToSort;
            System.out.print("Iteration " + (i) + ": ");
            printArray(arr);
        }

        return arr;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
