package com.university.ta.sorting;

import com.university.ta.student.Student;

import java.util.Comparator;

public final class MergeSort {

    private MergeSort() {
    }

    private static int iterations = 0;

    public static int getIterations() {
        return iterations;
    }

    public static void resetIterations() {
        iterations = 0;
    }

    public static Student[] sortStudents(Student[] students, Comparator<Student> comparator) {
        if (students.length <= 1) {
            return students;
        }
        Student[] first = new Student[students.length / 2];
        Student[] second = new Student[students.length - first.length];
        System.arraycopy(students, 0, first, 0, first.length);
        System.arraycopy(students, first.length, second, 0, second.length);
        sortStudents(first, comparator);
        sortStudents(second, comparator);
        merge(students, first, second, comparator);
        return students;
    }

    private static void merge(Student[] result, Student[] first, Student[] second, Comparator<Student> comparator) {
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;
        while (iFirst < first.length && iSecond < second.length) {
            if (comparator.compare(first[iFirst], second[iSecond]) < 0) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
            iterations++;
        }
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }

}
