package com.pandeyar.datastructure.sorting;

import java.util.Arrays;

/*
        Choose a pivot, it is generally mid element of the list.
        Initialise two index variable , left=0 and right=arr.length-1
        Increment left variable until you get element higher than pivot.
        Decrement right variable until you get element lesser than pivot
        swap arr[left] and arr[right]
        Recursively sort sublists(sublist with less than pivot, sublist greater than pivot) using above algorithm.
        In the end , you will get sorted array.
*/

public class QuickSort {
    private static int[] array;

    public static void sort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }
        array = arr;
        quickSort(0, array.length - 1);
    }

    private static void quickSort(int left, int right) {

        if(left >= right){
            return;
        }
        // find pivot number, we will take it as last element
        int pivot = array[right];


        int pivotPosition = partition(left, right, pivot);
        // call quickSort() method recursively
        quickSort(left, pivotPosition-1);
        quickSort(pivotPosition+1, right);
    }

    public static int partition(int left, int right, int pivot){
        int leftPointer = left -1;
        int rightPointer = right;
        while (leftPointer <= rightPointer) {
            /**
             * In each iteration, we will increment left until we find element greater than pivot
             * We will decrement right until we find element less than pivot
             */
            while (array[++leftPointer] < pivot) ;

            while (rightPointer > 0 && array[--rightPointer] > pivot) ;

            if (leftPointer <= rightPointer) {
                exchange(leftPointer, rightPointer);
            }
        }
        exchange(leftPointer, right); // its to put the pivot at the left pointer postion so that a different pivot is chosen in next iteration
        return leftPointer;
    }

    private static void exchange(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] a) {
        int[] input = {33, 21, 45, 64, 55, 34, 11, 8, 94, 5, 56};
        System.out.println("Before Sorting : ");
        System.out.println(Arrays.toString(input));
        sort(input);
        System.out.println("==================");
        System.out.println("After Sorting : ");
        System.out.println(Arrays.toString(array));

    }
}
