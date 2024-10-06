package com.pandeyar.datastructure.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Search in a sorted array which is rotated multiple times
 */
public class SearchInRotatedSortedArray {

    private static int searchInSortedAndRotatedArray(int[] inputArray, int searchValue) {
        int start = 0;
        int end = inputArray.length - 1;

        while (start <= end) {
            int mid = end - (end - start) / 2;
            if (inputArray[mid] == searchValue) {
                return mid;
            }

            int valueAtStart = inputArray[start];
            int valueAtEnd = inputArray[end];
            int valueAtMid = inputArray[mid];
            if (valueAtStart < valueAtMid) {  // That means the left half is sorted, and we need to apply binary search in this half
                if (valueAtStart <= searchValue && searchValue <= valueAtMid) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // That means the right half is sorted, and we need to apply binary search in this half
                if (valueAtEnd >= searchValue && searchValue >= valueAtMid) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{3, 4, 5, 6, 7, 0, 1, 2};
        printResults(inputArray, 7, searchInSortedAndRotatedArray(inputArray, 7));

        System.out.println();
        inputArray = new int[]{12, 13, 17, 19, 23, 24, 1, 2, 3, 4, 5, 8, 9, 10};
        printResults(inputArray, 4, searchInSortedAndRotatedArray(inputArray, 4));
    }

    private static void printResults(int[] input, int searchValue, int index) {
        System.out.printf(" input array: %s %s searchValue: %s %s indexOfSearchValue: %s%s",
                Arrays.stream(input).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]")),
                System.lineSeparator(),
                searchValue, System.lineSeparator(), index, System.lineSeparator());
    }
}
