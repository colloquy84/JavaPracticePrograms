package com.pandeyar.stringPrograms.shlok;

import java.util.Scanner;

public class PrintNCharacterOfString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide the master String");
        String masterString = scanner.next();
        System.out.println("Provide the other String which nees to be found in string provided above");
        String searchString = scanner.nextLine();

        findAndPrintOccurrencesOfString(masterString, searchString);
    }


    private static void findAndPrintOccurrencesOfString(String masterString, String searchString) {
        if (searchString == null || masterString == null) {
            System.out.println("Either master or search string is null");
            return;
        }

        if (searchString.length() > masterString.length()) {
            System.out.printf("Master string: %s has more characters than searchString: %s. It searchString can never be found in master string%n",
                    masterString, searchString);
            return;
        }

        char[] masterStringArray = masterString.toUpperCase().toCharArray();
        char[] searchStringArray = searchString.toUpperCase().toCharArray();

        int occurrences = 0;
        for (int masterIndex = 0; masterIndex < masterStringArray.length; masterIndex++) {
            boolean found = true;
            for (int searchIndex = 0; searchIndex < searchStringArray.length; searchIndex++) {
                if (searchIndex + masterIndex < masterStringArray.length) {
                    if (masterStringArray[searchIndex + masterIndex] != searchStringArray[searchIndex]) {
                        found = false;
                    }
                } else if (searchIndex < searchStringArray.length - 1) {
                    found = false;
                }
            }
            if (found) {
                occurrences++;
            }
        }

        System.out.printf("Number of occurrences of searchString:%s in masterString: %s are %s %n",
                searchString, masterString, occurrences);

    }
}


