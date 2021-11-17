package com.domain;

public class UndergraduateUnit extends Unit {
    private String unitId;
    private int unitLevel;
    private int assignment1;
    private int assignment2;
    private int practical;
    private int finalExam;
    private int overall;
    private String finalGrade;

    public UndergraduateUnit(String unitId, int unitLevel, int assignment1, int assignment2, int practical, int finalExam) {
        setEnrolmentType('U');
        this.unitId = unitId;
        this.unitLevel = unitLevel;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.practical = practical;
        this.finalExam = finalExam;

        overall = calculateOverallMark();
        finalGrade = determineFinalGrade(overall);
    }

    private int calculateOverallMark() {
        return (int)(assignment1*0.25 + assignment2*0.25 + practical*0.2 + finalExam*0.3);
    }

    public String getUnitId() {
        return unitId;
    }

    public int getOverall() {
        return overall;
    }

    public String getFinalGrade() {
        return finalGrade;
    }
}
