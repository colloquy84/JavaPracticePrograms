package com.pandeyar.other;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class FindSubsetOfAnArrayWithGivenSum {
    private static final String token = " ";

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int total = 60;

        System.out.println("Given Array");
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index] + " ");
        }
        System.out.println("total number of possible subset for this array where sum is equal to " +
                total + " are " + findNumberOFSubsetWithGivenSum(arr, total, arr.length - 1));

        System.out.println("All those subsets are given below");
        Set<String> allSubset = new HashSet<>(arr.length);
        findTargetSumSubsets(arr, total, "", 0, allSubset);
        for (String subSet : allSubset) {
            System.out.println("{ " + subSet + " }");
        }
    }

    private static int findNumberOFSubsetWithGivenSum(int[] arr, int total, int index) {

        if (total < 0) {
            return 0;
        } else if (total == 0) {
            return 1;
        } else if (index < 0) {
            return 0;
        } else if (total < arr[index]) {
            return findNumberOFSubsetWithGivenSum(arr, total, index - 1);
        } else {
            return findNumberOFSubsetWithGivenSum(arr, total - arr[index], index - 1)
                    + findNumberOFSubsetWithGivenSum(arr, total, index - 1);
        }

    }

    /**
     * The method for finding the subsets that sum to a target.
     *
     * @param input  The input array to be processed for subset with particular sum
     * @param target The target sum we are looking for
     * @param ramp   The Temporary String to be beefed up during recursive iterations(By default value an empty String)
     * @param index  The index used to traverse the array during recursive calls
     */
    public static void findTargetSumSubsets(int[] input, int target, String ramp, int index, Set<String> allSubset) {

        if (index > (input.length - 1)) {
            if (getSum(ramp) == target) {
                allSubset.add(ramp);
            }
            return;
        }

        //First recursive call going ahead selecting the int at the currenct index value
        findTargetSumSubsets(input, target, ramp + input[index] + token, index + 1, allSubset);
        //Second recursive call going ahead WITHOUT selecting the int at the currenct index value
        findTargetSumSubsets(input, target, ramp, index + 1, allSubset);
    }

    /**
     * A helper Method for calculating the sum from a string of integers
     *
     * @param intString the string subset
     * @return the sum of the string subset
     */
    private static int getSum(String intString) {
        int sum = 0;
        StringTokenizer sTokens = new StringTokenizer(intString, token);
        while (sTokens.hasMoreElements()) {
            sum += Integer.parseInt((String) sTokens.nextElement());
        }
        return sum;
    }
}
