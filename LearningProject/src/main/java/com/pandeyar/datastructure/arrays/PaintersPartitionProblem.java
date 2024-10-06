package com.pandeyar.datastructure.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given are N boards length of each board is given in the form of array,
 * there are M painters such that each painter takes 1 unit of time to paint 1 unit of the board
 * <p>
 * The task is to find the minimum time to paint all boards under the constraints that any painter will only paint
 * continuous section of the board.
 */
public class PaintersPartitionProblem {

    private static int minimumTimeToPaintAllBoard(int[] inputArray, int n, int m) {
        if (m > n) {
            return -1;
        }

        int maximumTime = 0;
        for (int index = 0; index < n; index++) {
            maximumTime += inputArray[index];
        }

        int answer = -1;
        int st = 0;
        int end = maximumTime;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (isAValidMinimumTime(inputArray, n, m, mid)) {
                answer = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }


        return answer;
    }

    private static boolean isAValidMinimumTime(int[] input, int n, int m, int maxAllowedTime) {
        int painters = 1;
        int time = 0;

        for (int index = 0; index < n; index++) {
            if (input[index] > maxAllowedTime) {
                return false;
            }

            if (time + input[index] <= maxAllowedTime) {
                time += input[index];
            } else {
                painters++;
                time = input[index];
            }
        }
        return painters <= m;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{40, 30, 20, 10};
        int numberOfPainters = 12;
        printResults(inputArray, numberOfPainters, minimumTimeToPaintAllBoard(inputArray, inputArray.length, numberOfPainters));

        System.out.println();

        inputArray = new int[]{15, 17, 20};
        numberOfPainters = 2;
        printResults(inputArray, numberOfPainters, minimumTimeToPaintAllBoard(inputArray, inputArray.length, numberOfPainters));

    }

    private static void printResults(int[] input, int numberOfStudents, int minNumberOfPagesForAnyStudent) {
        System.out.printf(" input array: %s %s numberOfPainters: %s %s minimumTimeToPaintAllBoard: %s %s",
                Arrays.stream(input).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]")),
                System.lineSeparator(),
                numberOfStudents, System.lineSeparator(), minNumberOfPagesForAnyStudent, System.lineSeparator());
    }
}
