package Assignment;

import java.util.Scanner;

public class StudentManagementUI {
    private static Scanner scanner;
    private static StudentManagement studentManagement;

    public static void main(String[] args) {
        studentManagement = new StudentManagement();
        scanner = new Scanner(System.in);
        showMenu();
    }

    public static void showMenu() {
        int choice;
        do {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add student");
            System.out.println("2. Update student");
            System.out.println("3. Delete student");
            System.out.println("4. Search student");
            System.out.println("5. Sort students by mark");
            System.out.println("6. Exit");
            System.out.print("Select an option (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    searchStudent();
                    break;
                case 5:
                    sortStudents();
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student mark: ");
        double mark = scanner.nextDouble();
        scanner.nextLine();  // Clear the buffer

        studentManagement.add(id, name, mark);
    }

    private static void updateStudent() {
        System.out.print("Enter student ID to update: ");
        String id = scanner.nextLine();
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new mark: ");
        double mark = scanner.nextDouble();
        scanner.nextLine();  // Clear the buffer

        studentManagement.update(id, name, mark);
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        String id = scanner.nextLine();
        studentManagement.delete(id);
    }

    private static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        String id = scanner.nextLine();
        studentManagement.search(id);
    }

    private static void sortStudents() {
        System.out.println("\nChoose sorting algorithm:");
        System.out.println("1. Quick Sort");
        System.out.println("2. Merge Sort");
        System.out.print("Select an option (1-2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer

        switch (choice) {
            case 1:
                studentManagement.sortByMarks();  // Quick Sort
                break;
            case 2:
                studentManagement.sortByMarksUsingMergeSort();  // Merge Sort
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
