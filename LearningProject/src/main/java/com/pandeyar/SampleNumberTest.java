package com.pandeyar;

public class SampleNumberTest {

    public static void main(String[] args) {

        int i = 0, k = 0, j = 0, l = 0, m = 0;

        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};

        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (i != j)
                    for (k = 0; k < 9; k++) {
                        if (j != k)
                            for (l = 0; l < 9; l++) {
                                if (k != l)
                                    for (m = 0; m < 9; m++) {
                                        if (l != m) {
                                            int sum = array[i] + array[j] + array[k] + array[l] + array[m];
                                            System.out.println("array[i] ::" + array[i]);
                                            System.out.println("array[j] ::" + array[j]);
                                            System.out.println("array[k] ::" + array[k]);
                                            System.out.println("array[l] ::" + array[l]);
                                            System.out.println("array[m] ::" + array[m]);
                                            System.out.println("Sum ::" + sum);
                                            System.out.println("***********************************");
                                        }

                                    }

                            }
                    }
            }
        }

    }

}
