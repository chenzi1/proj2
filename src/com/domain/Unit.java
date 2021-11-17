package com.domain;

public class Unit {
    private char enrolmentType;

    public void reportFinalGrade() {
        System.out.println("NA");
    }

    public char getEnrolmentType() {
        return enrolmentType;
    }

    public void setEnrolmentType(char enrolmentType) {
        this.enrolmentType = enrolmentType;
    }

    public String determineFinalGrade(int overallMark) {
        if (overallMark >= 80) {
            return "HD";
        } else if (overallMark >= 70) {
            return "D";
        } else if (overallMark >= 60) {
            return "C";
        } else if (overallMark >= 50) {
            return "P";
        } else {
            return "N";
        }
    }
}
