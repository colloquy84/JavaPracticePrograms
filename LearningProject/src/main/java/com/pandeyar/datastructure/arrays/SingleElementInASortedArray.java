package com.pandeyar.datastructure.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * You are given a sorted array contains only integers, where every element appears exactly twice but only one element appears once, find the element which appears only once
 */
public class SingleElementInASortedArray {

    private static int findTheElementWhichAppearsOnlyOnceInTHeSortedArray(int[] inputArray) {
        int start = 0;
        int end = inputArray.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;

            if (mid == 0 && inputArray[0] != inputArray[1]) {
                return inputArray[mid];
            } else if (mid == inputArray.length - 1 && inputArray[inputArray.length - 1] != inputArray[inputArray.length - 2]) {
                return inputArray[mid];
            } else if (inputArray[mid - 1] != inputArray[mid] && inputArray[mid] != inputArray[mid + 1]) {
                return inputArray[mid];
            }

            if (mid % 2 == 0) { // mid is even it means that the single element
                if (inputArray[mid - 1] == inputArray[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (inputArray[mid - 1] == inputArray[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }


        return inputArray[mid];
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 1, 3, 3, 6, 6, 9, 9, 11, 18, 18, 45, 45, 63, 63};
        printResults(inputArray, findTheElementWhichAppearsOnlyOnceInTHeSortedArray(inputArray));

        System.out.println();
        inputArray = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8, 9};
        printResults(inputArray, findTheElementWhichAppearsOnlyOnceInTHeSortedArray(inputArray));
    }

    private static void printResults(int[] input, int elementWhichAppearsOnlyOnce) {
        System.out.printf(" input array: %s %s element which appears only once: %s, %s",
                Arrays.stream(input).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]")),
                System.lineSeparator(),
                elementWhichAppearsOnlyOnce, System.lineSeparator());
    }
}
