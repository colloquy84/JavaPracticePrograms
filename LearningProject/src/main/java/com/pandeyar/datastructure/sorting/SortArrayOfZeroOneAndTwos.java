package com.pandeyar.datastructure.sorting;

public class SortArrayOfZeroOneAndTwos {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2, 1, 0, 1, 2, 0, 1};
        System.out.print("Inout Array: ");
        printArray(arr);
        System.out.println();
        sortArrayOfZeroOneAndTwos(arr);

    }

    public static void sortArrayOfZeroOneAndTwos(int[] arr) {
        int m = 0;
        int l = 0;
        int h = arr.length - 1;
        int iterationCount = 1;
        while (m < h) {
            if (arr[m] == 0) {
                swap(arr, m, l);
                m++;
                l++;
            } else if (arr[m] == 1) {
                m++;
            } else {
                swap(arr, m, h);
                h--;
            }
            System.out.print("Iteration " + iterationCount + ": ");
            printArray(arr);
            iterationCount++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
