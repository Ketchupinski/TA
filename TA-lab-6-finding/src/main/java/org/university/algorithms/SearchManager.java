package org.university.algorithms;

public final class SearchManager {

    private SearchManager() {}

    public static int[] linearSearch(int[] arr, int key) {
        int[] result = new int[arr.length];
        int resultSize = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                result[resultSize] = i;
                resultSize++;
            }
        }
        if (resultSize == 0) {
            return new int[0];
        }
        int[] resultCopy = new int[resultSize];
        System.arraycopy(result, 0, resultCopy, 0, resultSize);
        return resultCopy;
    }


    public static int[] linearSearchWithBarrier(int[] arr, int key) {
        int[] result = new int[arr.length];
        int resultSize = 0;
        int lastElement = arr[arr.length - 1];
        arr[arr.length - 1] = key;
        int i = 0;
        while (arr[i] != key) {
            i++;
        }
        arr[arr.length - 1] = lastElement;
        if (i == arr.length - 1 && arr[i] != key) {
            return new int[0];
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == key) {
                result[resultSize] = j;
                resultSize++;
            }
        }
        int[] resultCopy = new int[resultSize];
        System.arraycopy(result, 0, resultCopy, 0, resultSize);
        return resultCopy;
    }

    public static int[] binarySearch(int[] arr, int key) {
        sortArray(arr);
        int[] result = new int[arr.length];
        int resultSize = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (arr[middle] == key) {
                result[resultSize] = middle;
                resultSize++;
                int i = middle - 1;
                while (i >= 0 && arr[i] == key) {
                    result[resultSize] = i;
                    resultSize++;
                    i--;
                }
                i = middle + 1;
                while (i < arr.length && arr[i] == key) {
                    result[resultSize] = i;
                    resultSize++;
                    i++;
                }
                break;
            } else if (arr[middle] < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        if (resultSize == 0) {
            return new int[0];
        }
        int[] resultCopy = new int[resultSize];
        System.arraycopy(result, 0, resultCopy, 0, resultSize);
        return resultCopy;

    }

    private static void sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
