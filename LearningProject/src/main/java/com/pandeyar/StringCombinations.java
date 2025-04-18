package com.pandeyar;

public class StringCombinations {

    public static void main(String[] args) {

        combine("RUN", new StringBuffer(), 0);

    }

    static public void combine(String instr, StringBuffer outstr, int index) {
        for (int i = index; i < instr.length(); i++) {
            outstr.append(instr.charAt(i));
            System.out.print(outstr + " ");
            combine(instr, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
    }
}
