package com.domain;

public class UndergraduateStudent extends Student{

    private UndergraduateUnit undergraduateUnit;

    public UndergraduateStudent(String unitId, int unitLevel, int assignment1, int assignment2, int practical, int finalExam) {
        undergraduateUnit = new UndergraduateUnit(unitId, unitLevel, assignment1, assignment2, practical, finalExam);
    }

    @Override
    public void reportGrade() {
        System.out.println(undergraduateUnit.getEnrolmentType() +
                "\n" + String.join(" ", super.getFirstName(), super.getLastName()) +
                "\n" + super.getStudentNumber() +
                "\n" + undergraduateUnit.getUnitId() +
                "\n" + undergraduateUnit.getOverall() +
                "\n" + undergraduateUnit.getFinalGrade());
    }
}
