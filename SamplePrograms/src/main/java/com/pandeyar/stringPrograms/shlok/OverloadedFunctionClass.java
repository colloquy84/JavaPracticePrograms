package com.pandeyar.stringPrograms.shlok;

public class OverloadedFunctionClass {

    public static void main(String[] args) {
        OverloadedFunctionClass overloadedFunctionClass = new OverloadedFunctionClass();
        overloadedFunctionClass.check("success", 's');
        overloadedFunctionClass.check("success");
    }

    public void check(String input) {
        if (input == null) {
            System.out.println("Provided String is null");
        }
        char[] chars = input.toLowerCase().toCharArray();
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        int occurrences = 0;
        for (int index = 0; index < input.length(); index++) {
            for (int vowelIndex = 0; vowelIndex < vowels.length; vowelIndex++) {
                if (chars[index] == vowels[vowelIndex]) {
                    occurrences++;
                }
            }
        }
        System.out.printf("Number of occurrences of vowels in given string: %s are %s%n",
                input, occurrences);
    }

    public void check(String input, char ch) {
        if (input == null) {
            System.out.println("Provided String is null");
        }
        char[] chars = input.toCharArray();
        int occurrences = 0;
        for (int index = 0; index < input.length(); index++) {
            if (chars[index] == ch) {
                occurrences++;
            }
        }
        System.out.printf("Number of occurrences of %s in given string: %s are %s%n",
                ch, input, occurrences);
    }
}
