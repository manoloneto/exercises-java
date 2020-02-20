package systems.schoolSystem.models;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolClass {

    private String discipline;
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(String studentName) {
        for (Student student : this.students) {
            if (student.getName().equals(studentName)) {
                this.students.remove(student);
                break;
            }
        }
    }

    public void launchGrades() {
        Scanner in = new Scanner(System.in);

        for (Student student : this.students) {
            System.out.println("Student: " + student.getName());
            System.out.print("Grade A: ");
            student.setGradeA(in.nextDouble());
            System.out.print("Grade B: ");
            student.setGradeB(in.nextDouble());

            if (student.isApproved()) {
                System.out.println(student.getName() + " is approved!");
            } else {
                System.out.println(student.getName() + " is not approved...");
            }
        }
    }

    public void printStudents() {
        for (Student student : this.students) {
            System.out.println(student.getName());
        }
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
