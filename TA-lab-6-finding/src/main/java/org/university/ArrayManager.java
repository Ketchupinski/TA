package org.university;

import java.util.Random;

public final class ArrayManager {
    public static final int MAX_SIZE = 50;
    public static final int MAX_ELEMENT_VALUE = 255;

    public static final int LINEAR_SEARCH_KEY = 12 + 9; // 21

    public static final int LINEAR_SEARCH_WITH_BARRIER_KEY = 27 + 9; // 36

    public static final int  BINARY_SEARCH_KEY = (27 + 19) / 9; // 5


    private static int[] array;

    private ArrayManager() {}

    public static int[] getArray() {
        return array;
    }

    public static void setArray(int[] array) {
        ArrayManager.array = array;
    }

    private static final Random random = new Random();

    public static void createArrayWithRandomValues() {
        array = new int[MAX_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(MAX_ELEMENT_VALUE);
        }
    }
}
