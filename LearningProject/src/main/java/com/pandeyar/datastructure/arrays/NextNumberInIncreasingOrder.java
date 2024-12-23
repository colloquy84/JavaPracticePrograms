package com.pandeyar.datastructure.arrays;

public class NextNumberInIncreasingOrder {

    public static void main(String[] args) {
        int[] numberArray = {1, 2, 3, 4, 5};
        String inputNumber = getNumber(numberArray);
        System.out.println("Input Number: " + inputNumber);
        int[] nextNumberArray = findNextNumber(numberArray);
        String nextNumber = getNumber(nextNumberArray);
        while (!nextNumber.equals(inputNumber)) {
            System.out.println("Next Number: " + nextNumber);
            nextNumberArray = findNextNumber(nextNumberArray);
            nextNumber = getNumber(nextNumberArray);
        }

    }

    public static int[] findNextNumber(int[] numberArray) {
        int pivot = -1;
        for (int j = numberArray.length - 2; j >= 0; j--) {
            if (numberArray[j + 1] > numberArray[j]) {
                pivot = j;
                break;
            }
        }

        if (pivot != -1) {
            for (int i = numberArray.length - 1; i > pivot; i--) {
                if (numberArray[i] > numberArray[pivot]) {
                    swap(numberArray, i, pivot);
                    break;
                }
            }
            reverse(numberArray, pivot + 1, numberArray.length - 1);
        } else {
            //Since no greater number is possible simple revers the number array to find the smallest number
            reverse(numberArray, 0, numberArray.length - 1);
        }
        return numberArray;
    }

    public static String getNumber(int[] arr) {
        String number = "";
        for (int i = 0; i < arr.length; i++) {
            number = number + arr[i];
        }
        return number;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int firstNumber = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = firstNumber;
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start <= end) {
            swap(arr, start++, end--);
        }
    }
}
