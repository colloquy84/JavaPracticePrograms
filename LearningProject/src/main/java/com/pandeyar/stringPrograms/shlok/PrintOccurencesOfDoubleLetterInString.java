package com.pandeyar.stringPrograms.shlok;

import java.util.Scanner;

public class PrintOccurencesOfDoubleLetterInString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide the master String");
        String masterString = scanner.nextLine();

        printOccurrencesOfDoubleLettersInString(masterString);
    }


    private static void printOccurrencesOfDoubleLettersInString(String masterString) {
        if (masterString == null) {
            System.out.println("Provided string is null");
            return;
        }

        char[] masterStringArray = masterString.toUpperCase().toCharArray();

        int occurrences = 0;
        for (int masterIndex = 0; masterIndex < masterStringArray.length; masterIndex++) {
            if (masterIndex < masterStringArray.length - 1) {
                if (masterStringArray[masterIndex] == masterStringArray[masterIndex + 1]) {
                    occurrences++;
                    System.out.println("Double occurrence: " + masterStringArray[masterIndex] + masterStringArray[masterIndex]);
                }
            }
        }
        System.out.printf("Number of double letter occurrences in the given string: %s are %s %n",
                masterString.toUpperCase(), occurrences);
    }
}


