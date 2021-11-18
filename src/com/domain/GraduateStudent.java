package com.domain;

public class GraduateStudent extends Student {

    GraduateUnit graduateUnit;

    public GraduateStudent(String firstName, String lastName, long studentNumber, Date dataOfBirth) {
        super(firstName, lastName, studentNumber, dataOfBirth);
        graduateUnit = null;
    }

    public void setGraduateUnit(GraduateUnit graduateUnit) {
        this.graduateUnit = graduateUnit;
    }

    @Override
    public void reportGrade() {
        System.out.println("Enrolment Type: " + graduateUnit.getEnrolmentType() +
                "\n" + "Name: " + String.join(" ", super.getFirstName(), super.getLastName()) +
                "\n" + "Student Number: " + super.getStudentNumber() +
                "\n" + "Graduate Enrolment Type: " + graduateUnit.getGraduateEnrolmentType() +
                "\n" + "Final Grade: " + graduateUnit.getFinalGrade());
    }

    public String toString() {
        return String.join("|", getFirstName(),getLastName(),String.valueOf(getStudentNumber()),getDateOfBirth().toString(), graduateUnit != null? graduateUnit.toString() : null);
    }
}
