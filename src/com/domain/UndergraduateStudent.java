package com.domain;

public class UndergraduateStudent extends Student{

    private UndergraduateUnit undergraduateUnit;

    public UndergraduateStudent(String firstName, String lastName, long studentNumber, Date dataOfBirth) {
        super(firstName, lastName, studentNumber, dataOfBirth);
        undergraduateUnit = null;
    }

    public void setUndergraduateUnit(UndergraduateUnit undergraduateUnit) {
        this.undergraduateUnit = undergraduateUnit;
    }

    @Override
    public void reportGrade() {
        System.out.println("Enrolment Type: " + undergraduateUnit.getEnrolmentType() +
                "\n" + "Name: " + String.join(" ", super.getFirstName(), super.getLastName()) +
                "\n" + "Student Number: " + super.getStudentNumber() +
                "\n" + "Unit ID: " + undergraduateUnit.getUnitId() +
                "\n" + "Overall Mark: " + undergraduateUnit.getOverall() +
                "\n" + "Final Grade: " + undergraduateUnit.getFinalGrade());
    }

    public String toString() {
        return String.join("|", getFirstName(),getLastName(),String.valueOf(getStudentNumber()),getDateOfBirth().toString(),undergraduateUnit != null? undergraduateUnit.toString() : null);
    }
}
