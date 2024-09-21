package com.pandeyar.datastructure.arrays;

import java.util.Scanner;

public class FindSequentialNumberWithSumSameAsNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a positive integer for which you want to print sequential " +
                "numbers whose sume is same  as given number, or enter q to exit");
        String nextInput = scanner.next();

        while (!"q".equalsIgnoreCase(nextInput)) {
            try {
                int number = Integer.parseInt(nextInput);
                printNumberAsSequentialNumber(number);
            } catch (Exception e) {
                System.out.format("Please inter a valid integer %s is not a valid integer ", nextInput);
                System.out.println();
            }

            System.out.println("Enter a positive integer for which you want o to print sequential sums or enter q to exit");
            nextInput = scanner.next();
        }

        System.exit(0);
    }

    private static void printNumberAsSequentialNumber(int number) {
        System.out.println("Below are the sereis of numbers less than " + number + " whose sum is same as " + number);
        int n = 2; // A sum can be represented in at least two numbers
        while (true) {
            double expressionForSeries = 2 * number + n - n * n;
            if (expressionForSeries <= 0) {
                break;
            }
            double firstNubmerInSeries = expressionForSeries / (2 * n);
            int firstNumberInSeriesInInteger = (int) firstNubmerInSeries;
            if (firstNumberInSeriesInInteger == firstNubmerInSeries) {
                printSequence(firstNumberInSeriesInInteger, n);
            }
            n = n + 1;
        }

    }

    private static void printSequence(int startNumber, int numberOFTerms) {
        for (int i = 0; i < numberOFTerms; i++) {
            System.out.print(startNumber + i + " ");
        }
        System.out.println("\n");

    }

}
