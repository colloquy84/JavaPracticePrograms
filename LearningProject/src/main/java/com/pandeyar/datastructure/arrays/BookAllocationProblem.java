package com.pandeyar.datastructure.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * There are N books, each ith  book has A[i] number of pages.
 * You have to allocate books to M number of students so that the maximum number of pages allocated to a student is minimum.
 * <p>
 * • Each book should be allocated to a student.
 * • Each student has to be allocated at least one book.
 * • Allotment should be in contiguous order.
 * <p>
 * Calculate and return that minimum possible number.
 * Return -1 if a valid assignment is not possible.
 */
public class BookAllocationProblem {

    private static int allocateBooks(int[] inputArray, int n, int m) {
        if (m> n) {
            return -1;
        }

        int sum = 0;
        for (int index = 0; index < n; index++) {
            sum += inputArray[index];
        }

        int answer = -1;
        int st = 0;
        int end = sum;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (isValid(inputArray, n, m, mid)) {
                answer = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }


        return answer;
    }

    private static boolean isValid(int[] input, int n, int m, int maxAllowedPages) {
        int students = 1;
        int pages = 0;

        for (int index = 0; index < n; index++) {
            if (input[index] > maxAllowedPages) {
                return false;
            }

            if (pages + input[index] <= maxAllowedPages) {
                pages += input[index];
            } else {
                students++;
                pages = input[index];
            }
        }
        return students <= m;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{2, 1, 3, 4};
        printResults(inputArray, 2, allocateBooks(inputArray, inputArray.length, 2));
        System.out.println();
        inputArray = new int[]{15, 17, 20};
        printResults(inputArray, 2, allocateBooks(inputArray, inputArray.length, 2));

    }

    private static void printResults(int[] input, int numberOfStudents, int minNumberOfPagesForAnyStudent) {
        System.out.printf(" input array: %s %s numberOfStudents: %s %s minNumberOfPagesForAnyStudent: %s %s",
                Arrays.stream(input).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]")),
                System.lineSeparator(),
                numberOfStudents, System.lineSeparator(), minNumberOfPagesForAnyStudent, System.lineSeparator());
    }
}
