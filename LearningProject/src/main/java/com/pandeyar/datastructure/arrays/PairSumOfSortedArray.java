package com.pandeyar.datastructure.arrays;

public class PairSumOfSortedArray {

    //Find the pair in the array with given sum
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 5, 8, 12, 13, 19};
        int requiredSum = 15;

        int start = 0;
        int end = input.length - 1;

        while (start < end) {
            int currentSum = input[start] + input[end];
            if (currentSum < requiredSum) {
                start++;
            } else if (currentSum > requiredSum) {
                end--;
            } else {
                System.out.printf("Given sum %d can be derived usinmg array index %d and %d which has value %d and %d%n",
                        requiredSum, start, end, input[start], input[end]);
                break;
            }
        }
    }
}
