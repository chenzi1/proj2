package com.domain;

public class GraduateStudent extends Student {

    GraduateUnit graduateUnit;

    public GraduateStudent(String graduateEnrolmentType, int yearsTaken, char finalGrade) {
        graduateUnit = new GraduateUnit(graduateEnrolmentType, yearsTaken, finalGrade);
    }

    @Override
    public void reportGrade() {
        System.out.println(graduateUnit.getEnrolmentType() +
                "\n" + String.join(" ", super.getFirstName(), super.getLastName()) +
                "\n" + super.getStudentNumber() +
                "\n" + graduateUnit.getGraduateEnrolmentType() +
                "\n" + graduateUnit.getFinalGrade());
    }
}
