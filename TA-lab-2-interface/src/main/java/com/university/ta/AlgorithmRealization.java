package com.university.ta;

import javafx.scene.control.TextArea;

/**
 * Given a positive integer n > 1.
 * Print all prime factors of this number in increasing order with respect to multiplicity.
 * The algorithm must have complexity O (log n). Algorithm must not use loops.
 * (When solving problems, it is forbidden to use ribbons, lists, arrays and loops respectively).
 */
public final class AlgorithmRealization {


    private AlgorithmRealization() {}

    private static TextArea numbersArea;

    public static void printPrimeFactors(int number, TextArea area) {
        if (number < 2) {
            return;
        }
        numbersArea = area;
        printPrimeFactors(number, 2);
    }

    private static void printPrimeFactors(int number, int divisor) {
        if (number == 1) {
            return;
        }
        if (number % divisor == 0) {
            numbersArea.appendText(divisor + " - " + number + "\n");
            printPrimeFactors(number / divisor, divisor);
        } else {
            printPrimeFactors(number, divisor + 1);
        }
    }
}
