package com.university.ta.sorting;

import com.university.ta.student.Student;

import java.util.Comparator;

public final class HeapSort {

    private HeapSort() {}

    private static int iterations = 0;

    public static int getIterations() {
        return iterations;
    }

    public static void sort(Student[] students, Comparator<Student> comparator) {
        iterations = 0;
        int n = students.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(students, n, i, comparator);
        }
        for (int i = n - 1; i >= 0; i--) {
            Student temp = students[0];
            students[0] = students[i];
            students[i] = temp;
            heapify(students, i, 0, comparator);
        }
    }

    private static void heapify(Student[] students, int n, int i, Comparator<Student> comparator) {
        iterations++;
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && comparator.compare(students[l], students[largest]) > 0) {
            largest = l;
        }
        if (r < n && comparator.compare(students[r], students[largest]) > 0) {
            largest = r;
        }
        if (largest != i) {
            Student swap = students[i];
            students[i] = students[largest];
            students[largest] = swap;
            heapify(students, n, largest, comparator);
        }
    }
}
