package com.domain;

public class Student {
    private String firstName;
    private String lastName;
    private long studentNumber;
    private Date dateOfBirth;

    public Student() {};

    public Student(String firstName, String lastName, long studentNumber, Date dataOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.dateOfBirth = dataOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getStudentNumber() {
        return studentNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void reportGrade() {
        System.out.println("There is no grade here");
    }

    public boolean equals(Student student1, Student student2) {
        return student1.getStudentNumber() == student2.getStudentNumber();
    }
}
