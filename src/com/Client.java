package com;

import com.domain.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws FileNotFoundException {
        List<Student> studentList = new ArrayList<>();

        Scanner scanner = new Scanner(new File("students.csv"));
        while(scanner.hasNextLine()) {
            String[] params = scanner.nextLine().split(",");
            String[] dobString = params[4].split("/");
            if (params[0].equalsIgnoreCase("U")) {
                UndergraduateStudent undergraduateStudent = new UndergraduateStudent(params[1],params[2],Long.parseLong(params[3]),new Date(Integer.parseInt(dobString[0]), Integer.parseInt(dobString[1]), Integer.parseInt(dobString[2])));
                studentList.add(undergraduateStudent);
            } else if (params[0].equalsIgnoreCase("G")) {
                GraduateStudent graduateStudent = new GraduateStudent(params[1],params[2],Long.parseLong(params[3]),new Date(Integer.parseInt(dobString[0]), Integer.parseInt(dobString[1]), Integer.parseInt(dobString[2])));
                studentList.add(graduateStudent);
            }
        }
        scanner.close();

        boolean continueUserInput = true;
        while(continueUserInput) {
            scanner = new Scanner(System.in);
            System.out.println("Enter option:" +
                    "\n" + "1 - add unit/marks" +
                    "\n" + "2 - delete student" +
                    "\n" + "3 - show all students" +
                    "\n" + "4 - undergraduate performance" +
                    "\n" + "5 - report grade" +
                    "\n" + "0 - quit");

            int userInput = scanner.nextInt();

            switch(userInput) {
                case 1:
                    System.out.println("Enter the file name");
                    Scanner filenameInput = new Scanner(System.in);
                    String filename = filenameInput.nextLine();
                    Scanner fileReader = new Scanner(new File(filename));
                    while(fileReader.hasNextLine()) {
                        String[] marksLine = fileReader.nextLine().split(",");
                        for (int i = 0; i < studentList.size(); i++) {
                            if (studentList.get(i).getStudentNumber() == Integer.parseInt(marksLine[0])) {
                                if (studentList.get(i) instanceof UndergraduateStudent) {
                                    UndergraduateStudent undergraduateStudent = (UndergraduateStudent) studentList.get(i);
                                    UndergraduateUnit undergraduateUnit = new UndergraduateUnit(marksLine[1],Integer.parseInt(marksLine[2]),Integer.parseInt(marksLine[3]),Integer.parseInt(marksLine[4]),Integer.parseInt(marksLine[5]),Integer.parseInt(marksLine[6]));
                                    undergraduateStudent.setUndergraduateUnit(undergraduateUnit);
                                    studentList.set(i, undergraduateStudent);
                                } else if (studentList.get(i) instanceof  GraduateStudent) {
                                    GraduateStudent graduateStudent = (GraduateStudent) studentList.get(i);
                                    GraduateUnit graduateUnit = new GraduateUnit(marksLine[1],Integer.parseInt(marksLine[2]),marksLine[3].charAt(0));
                                    graduateStudent.setGraduateUnit(graduateUnit);
                                    studentList.set(i, graduateStudent);
                                }
                            }
                        }
                    }
                    System.out.println("Marks added");
                    break;
                case 2:
                    boolean studentFound = false;
                    int index = 0;
                    System.out.println("Enter the Student Number to be deleted");
                    Scanner studentNumberInput = new Scanner(System.in);
                    String studentNumber = studentNumberInput.nextLine();
                    for (int i = 0; i < studentList.size(); i++) {
                        if (studentList.get(i).getStudentNumber() == Integer.parseInt(studentNumber)) {
                            studentFound = true;
                            index = i;
                            break;
                        }
                    }
                    if (studentFound) {
                        System.out.println("Student found:" +
                                "\n" + studentNumber +
                                "\n" + String.join(" ", studentList.get(index).getFirstName(), studentList.get(index).getLastName()) +
                                "\n" + "Confirm deletion? (Y/N)");
                        Scanner optionInput = new Scanner(System.in);
                        String option = optionInput.nextLine();
                        if (option.equalsIgnoreCase("Y")) {
                            studentList.remove(index);
                            System.out.println("Student removed");
                        }
                    } else {
                        System.out.println("Student not found in list");
                    }
                    break;
                case 3:
                    System.out.println(studentList);
                    break;
                case 4:
                    //calculation of average overall
                case 5:
                    boolean studentNotFound = true;
                    System.out.println("Enter Student Number");
                    Scanner studentNumberInout = new Scanner(System.in);
                    int studentNum = studentNumberInout.nextInt();
                    for (Student student : studentList) {
                        if (student.getStudentNumber() == studentNum) {
                            student.reportGrade();
                            studentNotFound = false;
                        }
                    }
                    if (studentNotFound) System.out.println("Student not found in list");
                    break;
                case 0:
                    continueUserInput = false;
                    System.out.println("Thank you for using the system!");
                    break;
            }
        }
    }
}
