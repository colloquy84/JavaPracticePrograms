package com.pandeyar.datastructure.math;

/**
 * This class calculates exponents of a number in log(n) complexity, it is doing that by converting exponent into binary form and multiplying only
 * when binary digit is 1.
 * So if qwe need to calculate 4 ^ 5 the convert 5 into binary which is 101, now generate the power using (1 * 4^1) * (0* 4^2) * (1 ^ 4^4) ... like that
 *
 */
public class BinaryExponentiation {

    public static double power(double number, int power) {

        if (power == 0) return 1;
        if (number == 0) return 0.0;
        if (power == 1) return number;
        if (number == -1 && power % 2 == 0) return 1.0;
        if (number == -1 && power % 2 != 0) return -1.0;

        long binForm = power;
        if (power < 0) {
            number = 1 / number;
            binForm = -binForm;
        }

        double ans = 1;
        while (binForm > 0) {
            if (binForm % 2 == 1) {
                ans *= number;
            }
            number *= number;
            binForm /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 5;
        int y = 3;
        System.out.printf("power of %s to the power %s is %s%n", x, y, power(x, y));
        x = 10;
        y = 3;
        System.out.printf("power of %s to the power %s is %s%n", x, y, power(x, y));

        x = 5;
        y = 8;
        System.out.printf("power of %s to the power %s is %s%n", x, y, power(x, y));

        x = 5;
        y = -8;
        System.out.printf("power of %s to the power %s is %s%n", x, y, power(x, y));

        x = 5;
        y = -2;
        System.out.printf("power of %s to the power %s is %s%n", x, y, power(x, y));

        x = 4;
        y = 4;
        System.out.printf("power of %s to the power %s is %s%n", x, y, power(x, y));
    }
}
