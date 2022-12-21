package com.university.ta.student;

import java.util.Objects;

public class Student {
    private String surname;
    private int markPrograming;
    private int markComputerGraphics;
    private int markDataBases;
    private int markOperatingSystems;
    private int markWeb;

    public Student(String surname, int markPrograming, int markComputerGraphics, int markDataBases, int markOperatingSystems, int markWeb) {
        this.surname = surname;
        this.markPrograming = markPrograming;
        this.markComputerGraphics = markComputerGraphics;
        this.markDataBases = markDataBases;
        this.markOperatingSystems = markOperatingSystems;
        this.markWeb = markWeb;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getMarkPrograming() {
        return markPrograming;
    }

    public void setMarkPrograming(int markPrograming) {
        this.markPrograming = markPrograming;
    }

    public int getMarkComputerGraphics() {
        return markComputerGraphics;
    }

    public void setMarkComputerGraphics(int markComputerGraphics) {
        this.markComputerGraphics = markComputerGraphics;
    }

    public int getMarkDataBases() {
        return markDataBases;
    }

    public void setMarkDataBases(int markDataBases) {
        this.markDataBases = markDataBases;
    }

    public int getMarkOperatingSystems() {
        return markOperatingSystems;
    }

    public void setMarkOperatingSystems(int markOperatingSystems) {
        this.markOperatingSystems = markOperatingSystems;
    }

    public int getMarkWeb() {
        return markWeb;
    }

    public void setMarkWeb(int markWeb) {
        this.markWeb = markWeb;
    }

    public double getAverageMark() {
        return (this.getMarkPrograming() + this.getMarkComputerGraphics() + this.getMarkDataBases() + this.getMarkOperatingSystems() + this.getMarkWeb()) / 5.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return markPrograming == student.markPrograming && markComputerGraphics == student.markComputerGraphics && markDataBases == student.markDataBases && markOperatingSystems == student.markOperatingSystems && markWeb == student.markWeb && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, markPrograming, markComputerGraphics, markDataBases, markOperatingSystems, markWeb);
    }
}
