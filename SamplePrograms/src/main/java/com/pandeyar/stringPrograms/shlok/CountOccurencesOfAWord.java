package com.pandeyar.stringPrograms.shlok;

import java.util.Scanner;

public class CountOccurencesOfAWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide the input String for extraction");
        String input = scanner.nextLine();
        System.out.println("Provide start index");
        int startIndex = scanner.nextInt();
        System.out.println("Provide number of characters to extract");
        int numberOfCharactersToExtract = scanner.nextInt();
        printAndExtractCharacters(input, startIndex, numberOfCharactersToExtract);
    }


    private static void printAndExtractCharacters(String input, int startIndex, int numberOfCharactersToExtract) {
        if (input == null) {
            System.out.println("Provided input string is null");
            return;
        }

        if (input.length() <= startIndex || input.length() <= (startIndex + numberOfCharactersToExtract)) {
            System.out.printf("Total number of characters in the String are only %s, we cannot extract" +
                            " %s character staring from index %s%n", input.length(), numberOfCharactersToExtract,
                    startIndex);
            return;
        }

        char[] chars = input.toCharArray();

        System.out.printf("Printing %s characters of input String %s from start index %s%n",
                numberOfCharactersToExtract, input, startIndex);
        for (int index = startIndex; index < startIndex + numberOfCharactersToExtract; index++) {
            System.out.print(chars[index] + " ");
        }

    }
}

