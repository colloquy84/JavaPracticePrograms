package com.pandeyar.datastructure.arrays;


/**
 * Find the element in the majority element in given array majority element is the element which appearsfloor(array length /2) times
 * <p>
 * This class uses Moor's voting algorithm
 */
public class MajorityElement {
    public static void main(String[] args) {

        int[] input = new int[]{1, 1, 2, 2, 1};

        int freq = 0;
        int ans = 0;

        for (int index = 0; index < input.length; index++) {
            if (freq == 0) {
                ans = input[index];
            }

            if (ans == input[index]) {
                freq++;
            } else {
                freq--;
            }
        }

        //Below additional loop needs to be run when we are not sure if a majority element exists in the array.
        // If there is no majority element exists then Moor's algorithm simply return the last value in the array
        int count = 0;
        for (int index = 0; index < input.length; index++) {
            if (input[index] == ans) {
                count++;
            }
        }

        if (count > input.length / 2) {
            System.out.println("Majority element in the given array is " + ans);
        } else {
            System.out.println("Majority element does not exist in given array");
        }


    }
}
