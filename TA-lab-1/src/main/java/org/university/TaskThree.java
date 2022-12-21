package org.university;

/**
 * Find all pairs of mutually prime numbers in the interval [M, N],
 * where M is the year is the year of your birth and N is the current year multiplied by 2.
 * M = 2022 N = 2002 * 2 = 4004
 */
public class TaskThree {
    public static void main(String[] args) {
        int m = 2022;
        int n = 4004;
        for (int i = m; i <= n; i++) {
            for (int j = m; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    System.out.println("NSD(" + i + ", " + j + ") = 1");
                }
            }
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
