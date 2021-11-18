package com.domain;

public class GraduateUnit extends Unit {
    private String graduateEnrolmentType;
    private int yearsTaken;
    private char finalGrade;

    public GraduateUnit(String graduateEnrolmentType, int yearsTaken, char finalGrade) {
        setEnrolmentType('G');
        this.graduateEnrolmentType = graduateEnrolmentType;
        this.yearsTaken = yearsTaken;
        this.finalGrade = finalGrade;
    }

    public String getGraduateEnrolmentType() {
        return graduateEnrolmentType;
    }

    public int getYearsTaken() {
        return yearsTaken;
    }

    public char getFinalGrade() {
        return finalGrade;
    }

    public String toString() {
        return String.join("|", graduateEnrolmentType,String.valueOf(yearsTaken),String.valueOf(finalGrade));
    }
}
