package com.pandeyar.datastructure.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given an array of integer return an array of same size,
 * which will contain product of each element of that array except the element of that index stored at each index
 * <p>
 * You cannot use division operator in this one
 */
public class ProductOfAnArrayExceptSelf {
    private static int[] findProductOfAnArrayExceptSelf(int[] inputArray) {
        int[] outputArray = new int[inputArray.length];
        outputArray[0] = 1;

        //This steps stored the product of all values stored before the index
        for (int index = 1; index < inputArray.length; index++) {
            outputArray[index] = outputArray[index - 1] * inputArray[index - 1];
        }

        int suffix = 1;
        //This method will find the product of all numbers stored after the index and multiple with the value store at that index
        for (int index = inputArray.length - 2; index >= 0; index--) {
            suffix = suffix * inputArray[index + 1];
            outputArray[index] = outputArray[index] * suffix;
        }

        return outputArray;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{1, 2, 3, 4};
        printResults(inputArray, findProductOfAnArrayExceptSelf(inputArray));

        System.out.println();
        inputArray = new int[]{12, 1, 2, 3, 4, 5, 12, 23, 2, 3, 4};
        printResults(inputArray, findProductOfAnArrayExceptSelf(inputArray));
    }

    private static void printResults(int[] input, int[] output) {
        System.out.printf("input array:  %s %soutput array: %s%n",
                Arrays.stream(input).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]")),
                System.lineSeparator(),
                Arrays.stream(output).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]")));
    }
}
