package com.pandeyar.datastructure.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * If an array stores the integers which represents the height of a wall find the two indices which will form a container that will store most
 * amount of water in it
 */

public class MostAmountOfWater {

    public static int findMaxAmountOfWaterStoredInTheContainer(int[] arrayOfPossibleContainerWalls) {
        int containerVolume = 0;
        int start = 0;
        int end = arrayOfPossibleContainerWalls.length - 1;

        while (start < end) {
            int containerWidth = end - start;
            int containerHeight = Math.min(arrayOfPossibleContainerWalls[start], arrayOfPossibleContainerWalls[end]);
            containerVolume = containerWidth * containerHeight;
            if (arrayOfPossibleContainerWalls[start] < arrayOfPossibleContainerWalls[end]) {
                start++;
            } else {
                end--;

            }
        }
        return containerVolume;
    }

    public static void main(String[] args) {
        int[] containerArray = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        printResults(containerArray, findMaxAmountOfWaterStoredInTheContainer(containerArray));
    }

    private static void printResults(int[] containerArray, int maxAmountOfWaterStoredInTheContainer) {
        System.out.printf("Max amount of water which can be stored in any container formed from the numbers of array %s are %s%n",
                Arrays.stream(containerArray).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]")),
                maxAmountOfWaterStoredInTheContainer);
    }
}
