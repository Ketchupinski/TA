package com.university.ta.student;

import javafx.scene.chart.XYChart;

import java.util.Collection;

public final class StudentManager {

    private StudentManager() {
    }

    public static Student[] createStudents() {
        Student[] students = new Student[13];

        students[0] = new Student("Savshak", 3, 3, 3, 3, 3);
        students[1] = new Student("Panchyshak", 4, 4, 4, 4, 4);
        students[2] = new Student("Yachechak", 5, 5, 5, 5, 5);
        students[3] = new Student("Klimashevskiy", 5, 5, 5, 5, 5);
        students[4] = new Student("Senishin", 5, 5, 5, 5, 5);
        students[5] = new Student("Kotik", 4, 5, 3, 4, 3);
        students[6] = new Student("Bilionok", 4, 3, 4, 3, 4);
        students[7] = new Student("Ilyushin", 3, 5, 4, 4, 5);
        students[8] = new Student("Obuhov", 5, 5, 5, 5, 5);
        students[9] = new Student("Papka", 3, 3, 3, 3, 4);
        students[10] = new Student("Fedishin", 5, 4, 3, 4, 3);
        students[11] = new Student("Uzefovish", 3, 3, 3, 3, 5);
        students[12] = new Student("Kobirinka", 4, 4, 4, 4, 4);
        return students;
    }
}
