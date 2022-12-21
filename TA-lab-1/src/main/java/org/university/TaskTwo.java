package org.university;

/**
 * It is known that for any positive integers a and b there exist
 * such x and y that a * x + b * y = d, where d = NSD(a, b). Given a and b find such x, y, d.
 */
public class TaskTwo {
    public static void main(String[] args) {
        int a = 589;
        int b = 343;
        int[] result = gcd(a, b);
        System.out.println("NSD(" + a + ", " + b + ") = " + result[0]);
        System.out.println("x = " + result[1]);
        System.out.println("y = " + result[2]);

    }

    public static int[] gcd(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0};
        }
        int[] result = gcd(b, a % b);
        int d = result[0];
        int x = result[2];
        int y = result[1] - (a / b) * result[2];
        return new int[]{d, x, y};
    }
}
