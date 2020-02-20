package systems.schoolSystem;

import systems.schoolSystem.models.SchoolClass;
import systems.schoolSystem.models.Student;

import java.util.Scanner;

public class SchoolSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Student student = new Student();
        SchoolClass schoolClass = new SchoolClass();

        schoolClass.setDiscipline("English");

        int option = 0;

        do {
            System.out.println("----- Menu -----");
            System.out.println("1 - Add new student");
            System.out.println("2 - Remove student");
            System.out.println("3 - Launch grades");
            System.out.println("4 - Print student names");
            System.out.println("5 - Exit");

            System.out.print("What is your option: ");
            option = in.nextInt();

            switch (option) {
                case 1:
                    System.out.println("What is the name of student to add?");
                    String name = in.next();

                    student = new Student();
                    student.setName(name);

                    schoolClass.addStudent(student);
                    break;

                case 2:
                    System.out.println("What is the name of student to remove?");
                    schoolClass.removeStudent(in.next());
                    break;

                case 3:
                    schoolClass.launchGrades();
                    break;

                case 4:
                    schoolClass.printStudents();
                    break;
            }

        } while (option != 5);
    }
}
