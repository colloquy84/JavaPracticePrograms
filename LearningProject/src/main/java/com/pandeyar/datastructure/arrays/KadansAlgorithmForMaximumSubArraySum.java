package com.pandeyar.datastructure.arrays;

/**
 * This class demonstrates Kadan's algorithm to find the maximum sum of any sub array for the given array.
 */
public class KadansAlgorithmForMaximumSubArraySum {


    public static void main(String[] args) {
        int[] input = new int[]{1, 2, -3, -4, 3, 4, -8, -9, 12, 5, 4, 3, 8, -10};

        int maxSum = -1 * Integer.MAX_VALUE;
        int currentSum = 0;
        for (int index = 0; index < input.length; index++) {
            currentSum += input[index];
            maxSum = Math.max(currentSum, maxSum);

            //Kadans algorithm says if the sume is negative reset it to zero
            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        System.out.printf(String.format("Maximum sum of any subarray for the given array %s is %d", input.toString(), maxSum));
    }
}
