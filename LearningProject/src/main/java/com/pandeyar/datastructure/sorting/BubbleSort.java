package com.pandeyar.datastructure.sorting;


/**
 * Compare two adjacent number and switch if they are not in desired order
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {100, 20, 15, 30, 5, 75, 40};
        bubbleSort(arr);

    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.print("Iteration " + (i + 1) + ": ");
            printArray(arr);
            if (!swapped) {
                break;
            }
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
