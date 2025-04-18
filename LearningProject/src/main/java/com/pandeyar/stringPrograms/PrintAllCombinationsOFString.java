package com.pandeyar.stringPrograms;

import java.util.HashSet;
import java.util.Set;

public class PrintAllCombinationsOFString {
    public static void main(String[] args) {
//        System.out.println("Enter a String  ");
        String str = "ARUN";//new Scanner(System.in).next();
        Set<String> stringSet = getASetWithAllCombinations(str);
        System.out.println("ALL combinations of String " + str + " are as below");
        for (String combinations : stringSet) {
            System.out.print(combinations + " ");
        }

    }

    public static Set<String> getASetWithAllCombinations(String str) {
        Set<String> stringSet = new HashSet<>();
        if (str.length() == 0) {
            stringSet.add("");
            return stringSet;
        }

        char firstCharcter = str.charAt(0);
        Set<String> combinationSetWithoutFirstCharacter = getASetWithAllCombinations(str.substring(1));
        for (String combination : combinationSetWithoutFirstCharacter) {
            for (int i = 0; i <= combination.length(); i++) {
                stringSet.add(addCharToStringatGivendIndex(combination, firstCharcter, i));
            }
        }
        return stringSet;
    }

    private static String addCharToStringatGivendIndex(String str, char firstCharcter, int index) {
        return str.substring(0, index) + firstCharcter + str.substring(index);
    }
}
