package com.pandeyar.stringPrograms;

import java.util.HashSet;
import java.util.Set;

public class PrintAllSubstringOFString {
    public static void main(String[] args) {
//        System.out.println("Enter a String  ");
        String str = "ARUN";//new Scanner(System.in).next();
        Set<String> stringSet = getASetWithAllSubstrings(str);
        System.out.println("ALL substrings of String " + str + " are as below");
        for (String combinations : stringSet) {
            System.out.print(combinations + " ");
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
