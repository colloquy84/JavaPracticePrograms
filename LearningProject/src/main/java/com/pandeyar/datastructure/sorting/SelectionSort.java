package com.pandeyar.datastructure.sorting;

import java.util.Arrays;

/**
 * Find the lowest/highest number first and bring that to the beginning of the array
 */
public class SelectionSort {
    public static int[] selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int indexOfMinValue = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[indexOfMinValue])
                    indexOfMinValue = j;

            int smallerNumber = arr[indexOfMinValue];
            arr[indexOfMinValue] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }

    public static void main(String[] a) {

        int[] arr = {40, 10, -30, 45, 39, 32};
        System.out.println("Before Sorting : ");
        System.out.println(Arrays.toString(arr));
        arr = selectionSort(arr);
        System.out.println("===================");
        System.out.println("After Sorting : ");
        System.out.println(Arrays.toString(arr));
    }
}
