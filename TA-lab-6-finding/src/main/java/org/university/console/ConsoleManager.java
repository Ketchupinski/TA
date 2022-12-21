package org.university.console;

import org.university.ArrayManager;
import org.university.algorithms.SearchManager;

import java.util.Scanner;

public class ConsoleManager {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        while (true) {
            System.out.println("1. Fill array with random values");
            System.out.println("2. Fill array with values from console");
            System.out.println("3. Print array");
            System.out.println("4. Linear search");
            System.out.println("5. Linear search with barrier");
            System.out.println("6. Binary search (automatic sort)");
            System.out.println("7. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    ArrayManager.createArrayWithRandomValues();
                    System.out.println("Array was filled with random values");
                }
                case 2 -> {
                    while (true) {
                        System.out.println("Enter array size(from 1 to 50): ");
                        int size = scanner.nextInt();
                        if (size > ArrayManager.MAX_SIZE) {
                            System.out.println("Array size is too big");
                            continue;
                        }
                        int[] array = new int[size];
                        for (int i = 0; i < size; i++) {
                            System.out.println("Enter array[" + i + "] value: ");
                            array[i] = scanner.nextInt();
                        }
                        ArrayManager.setArray(array);
                        break;
                    }

                }
                case 3 -> {
                    int[] array = ArrayManager.getArray();
                    if (array == null) {
                        System.out.println("Array is empty");
                        break;
                    }
                    for (int i = 0; i < array.length; i++) {
                        System.out.println("array[" + i + "] = " + array[i]);
                    }
                }
                case 4 -> {
                    int[] result = SearchManager.linearSearch(ArrayManager.getArray(), ArrayManager.LINEAR_SEARCH_KEY);
                    if (result.length == 0) {
                        System.out.println("Key not found");
                    } else {
                        System.out.println("Key " + ArrayManager.LINEAR_SEARCH_KEY + " found at positions: ");
                        for (int index : result) {
                            System.out.println(index);
                        }
                    }
                }
                case 5 -> {
                    int[] result = SearchManager.linearSearchWithBarrier(ArrayManager.getArray(), ArrayManager.LINEAR_SEARCH_WITH_BARRIER_KEY);
                    if (result.length == 0) {
                        System.out.println("Key not found");
                    } else {
                        System.out.println("Key " + ArrayManager.LINEAR_SEARCH_WITH_BARRIER_KEY + " found at positions: ");
                        for (int index : result) {
                            System.out.println(index);
                        }
                    }
                }
                case 6 -> {
                    int[] result = SearchManager.binarySearch(ArrayManager.getArray(), ArrayManager.BINARY_SEARCH_KEY);
                    if (result.length == 0) {
                        System.out.println("Key not found");
                    } else {
                        System.out.println("Key " + ArrayManager.BINARY_SEARCH_KEY + " found at positions: ");
                        for (int index : result) {
                            System.out.println(index);
                        }
                    }
                }
                case 7 -> {
                    return;
                }
                default -> System.out.println("Wrong choice");
            }
        }
    }

}
