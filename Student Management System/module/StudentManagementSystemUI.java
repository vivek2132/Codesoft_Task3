package module;

import java.util.Scanner;

public class StudentManagementSystemUI {
    private static StudentManagementSystem system = new StudentManagementSystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        int rollNumber;
        while (true) {
            System.out.print("Enter roll number: ");
            if (scanner.hasNextInt()) {
                rollNumber = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break;
            } else {
                System.out.println("Invalid input. Roll number must be an integer.");
                scanner.nextLine(); // Consume invalid input
            }
        }

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        // Validate input
        if (name.isEmpty() || grade.isEmpty()) {
            System.out.println("Error: Name and grade cannot be empty.");
        } else {
            Student student = new Student(name, rollNumber, grade);
            system.addStudent(student);
            System.out.println("Student added successfully.");
        }
    }

    private static void removeStudent() {
        System.out.print("Enter roll number of student to remove: ");
        int rollNumber = getIntInput();

        Student student = system.searchStudentByRollNumber(rollNumber);
        if (student != null) {
            system.removeStudent(student);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void searchStudent() {
        System.out.print("Enter roll number of student to search: ");
        int rollNumber = getIntInput();

        Student student = system.searchStudentByRollNumber(rollNumber);
        if (student != null) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents() {
        system.displayAllStudents();
    }

    private static int getIntInput() {
        while (true) {
            try {
                System.out.print("Enter a number: ");
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);
                return number;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

}
