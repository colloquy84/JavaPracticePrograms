package com.pandeyar.datastructure.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Find the peak Index in a mountain array
 */
public class FindPeakInMountainArray {

    private static int findPeakIndexInMountainArray(int[] inputArray) {
        int start = 0;
        int end = inputArray.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = end - (end - start) / 2;

            if (inputArray[mid - 1] < inputArray[mid] && inputArray[mid] > inputArray[mid + 1]) {
                return mid;
            } else if (inputArray[mid - 1] < inputArray[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }


        return mid;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 13, 14, 3, 1};
        printResults(inputArray, findPeakIndexInMountainArray(inputArray));

        System.out.println();
        inputArray = new int[]{1, 9, 12, 13, 80, 92, 101, 90, 80, 7, 6, 1, -1};
        printResults(inputArray, findPeakIndexInMountainArray(inputArray));
    }

    private static void printResults(int[] input, int peakIndex) {
        System.out.printf(" input array: %s %s peakIndex: %s, %s",
                Arrays.stream(input).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]")),
                System.lineSeparator(),
                peakIndex, System.lineSeparator());
    }
}
