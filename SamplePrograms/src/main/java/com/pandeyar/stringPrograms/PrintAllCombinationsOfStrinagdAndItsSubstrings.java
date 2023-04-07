package com.pandeyar.stringPrograms;

import java.util.HashSet;
import java.util.Set;

public class PrintAllCombinationsOfStrinagdAndItsSubstrings {
    public static void main(String[] args) {
//        System.out.println("Enter a String  ");
        String str = "ARUN";//new Scanner(System.in).next();
        Set<String> stringSet = PrintAllSubstringOFString.getASetWithAllSubstrings(str);
        System.out.println("ALL combinations of String " + str + " and all its substrings are as below");
        for (String substring : stringSet) {
            System.out.println("Substring: "+substring);
            System.out.print("Combinations: ");
            Set<String> combinationsSet = PrintAllCombinationsOFString.getASetWithAllCombinations(substring);
            for (String combination : combinationsSet){
                System.out.print(combination + " ");
            }
            System.out.println("\n===========================\n");
        }

    }

    public static Set<String> getASetWithAllSubstrings(String str) {
        Set<String> stringSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                stringSet.add(str.substring(i, j));
            }
        }
        return stringSet;
    }
}
