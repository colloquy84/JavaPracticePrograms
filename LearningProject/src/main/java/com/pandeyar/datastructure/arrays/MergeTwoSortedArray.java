package com.pandeyar.datastructure.arrays;

public class MergeTwoSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 6, 8, 9};
        System.out.print("Input Array1: ");
        printArray(arr1);
        int[] arr2 = {2, 5, 6};
        System.out.print("Input Array2: ");
        printArray(arr2);
        System.out.println();
        int[] output = mergeTwoArrays(arr1, arr2);
        System.out.print("Merged Array: ");
        printArray(output);
    }

    public static int[] mergeTwoArrays(int[] arr1, int[] arr2) {
        int firstArrayLength = arr1.length;
        int sec0ondArrayLength = arr2.length;
        int[] output = new int[firstArrayLength + sec0ondArrayLength];

        int i = firstArrayLength - 1;
        int j = sec0ondArrayLength - 1;
        int outputIndex = firstArrayLength + sec0ondArrayLength - 1;
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                output[outputIndex--] = arr1[i];
                i--;
            } else {
                output[outputIndex--] = arr2[j];
                j--;
            }
        }

        while (i >= 0) {
            output[outputIndex--] = arr1[i--];
        }

        while (j >= 0) {
            output[outputIndex--] = arr1[j--];
        }


        return output;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
