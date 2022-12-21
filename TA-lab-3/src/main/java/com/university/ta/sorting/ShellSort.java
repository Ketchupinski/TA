package com.university.ta.sorting;

import com.university.ta.student.Student;

import java.util.Comparator;

public class ShellSort {

    private ShellSort() {}

    private static int iterations = 0;

    public static int getIterations() {
        return iterations;
    }

    public static Student[] sortStudents(Student[] students, Comparator<Student> comparator) {
        iterations = 0;
        int step = students.length / 2;
        while (step > 0) {
            for (int i = 0; i < (students.length - step); i++) {
                int j = i;
                while (j >= 0 && comparator.compare(students[j], students[j + step]) > 0) {
                    Student temp = students[j];
                    students[j] = students[j + step];
                    students[j + step] = temp;
                    j--;
                    iterations++;
                }
            }
            step = step / 2;
        }
        return students;
    }

}

