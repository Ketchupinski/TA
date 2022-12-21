package org.university;

/**
 * Let two integers a, c, b be given, where a > 0 and b > 0; you are required to
 * find the greatest common divisor of NSD(a, b) and NSD(a, b, c) of numbers a and b and c,
 */
public class TaskOne {
    public static void main(String[] args) {
        int a = 594;
        int b = 792;
        int c = 962;
        int gcd = gcd(a, b);
        System.out.println("NSD(" + a + ", " + b + ") = " + gcd);
        int gcd2 = gcd(gcd, c);
        System.out.println("NSD(" + a + ", " + b + ", " + c + ") = " + gcd2);

        a = 9453;
        b = 4384;
        int gcd3 = gcd(a, b);
        System.out.println("NSD(" + a + ", " + b + ") = " + gcd3);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
