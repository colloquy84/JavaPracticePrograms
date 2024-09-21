package com.pandeyar.stringPrograms;

public class CheckIfStringIsRotaionofSomeString {
    public static void main(String[] args) {
        checkRotation("ArunPandey", "unPandeyAr");
        checkRotation("HARSHIT", "ITHARSH");
        checkRotation("HARSHIT", "ITHARHS");

    }

    private static void checkRotation(String firstString, String secondString) {
        //check if firstString can be achived by rotating second string
        String str = secondString + secondString;

        System.out.println("String " + firstString + " is a rotation of " + secondString + " : " +
                (str.indexOf(firstString) != -1));
    }

}
