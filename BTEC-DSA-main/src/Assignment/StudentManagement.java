package Assignment;

import Helper.*;

import java.io.File;
import java.util.*;

public class StudentManagement {
    private TreeMap<String, Student> database;

    public StudentManagement() {
        database = new TreeMap<>();
        String filePath = System.getProperty("user.dir") + "/student.csv";
        File csvFile = new File(filePath);

        System.out.println("Reading data from CSV file..." + filePath);

        if (csvFile.exists()) {
            database.putAll(readCSV.csvToMap(filePath));
            System.out.println("Loaded " + database.size() + " students.");
        } else {
            System.out.println("CSV file not found at path: " + filePath);
            System.out.println("Starting with an empty student database.");
        }
    }

    public void add(String id, String name, double mark) {
        if (mark < 0.0 || mark > 10.0) {
            System.out.println("Invalid mark: " + mark + ". Mark must be between 0.0 and 10.0.");
            return;
        }

        Student newStudent = new Student(id, name, mark);
        database.put(id, newStudent);
        System.out.println("Added student: " + newStudent.getName());
    }

    public void update(String id, String name, double mark) {
        if (database.containsKey(id)) {
            Student updatedStudent = new Student(id, name, mark);
            database.put(id, updatedStudent);
            System.out.println("Updated student: " + updatedStudent.getName());
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public int delete(String id) {
        if (database.containsKey(id)) {
            database.remove(id);
            System.out.println("Deleted student with ID: " + id);
            return 1;
        } else {
            System.out.println("Student with ID " + id + " not found.");
            return 0;
        }
    }

    public void search(String id) {
        if (id == null || id.isEmpty()) {
            System.out.println("Error: Invalid ID.");
            return;
        }
        Student student = database.get(id);
        if (student != null) {
            student.getStudent();
        } else {
            System.out.println("Error: Student with ID " + id + " not found.");
        }
    }

    // Quick Sort with time and memory measurement
    public void sortByMarks() {
        List<Student> studentList = new ArrayList<>(database.values());

        // Memory and time measurement before execution
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Clear garbage for accurate measurement

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        quickSort(studentList, 0, studentList.size() - 1);

        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

        long memoryUsed = memoryAfter - memoryBefore;
        long duration = endTime - startTime;

        System.out.println("Quick Sort completed in " + duration / 1_000_000.0 + " ms");
        System.out.println("Memory used: " + memoryUsed + " bytes");
    }

    private void quickSort(List<Student> list, int low, int high) {
        if (low < high) {
            int pi = partition(list, low, high);
            quickSort(list, low, pi - 1);
            quickSort(list, pi + 1, high);
        }
    }

    private int partition(List<Student> list, int low, int high) {
        double pivot = list.get(high).getMark();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (list.get(j).getMark() < pivot) {
                i++;
                Student temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        Student temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }

    // Merge Sort with time and memory measurement
    public void sortByMarksUsingMergeSort() {
        List<Student> studentList = new ArrayList<>(database.values());

        // Memory and time measurement before execution
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Clear garbage for accurate measurement

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        long startTime = System.nanoTime();

        List<Student> sortedList = mergeSort(studentList);

        long endTime = System.nanoTime();
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

        long memoryUsed = memoryAfter - memoryBefore;
        long duration = endTime - startTime;

        System.out.println("Merge Sort completed in " + duration / 1_000_000.0 + " ms");
        System.out.println("Memory used: " + memoryUsed + " bytes");
    }

    private List<Student> mergeSort(List<Student> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<Student> left = mergeSort(list.subList(0, mid));
        List<Student> right = mergeSort(list.subList(mid, list.size()));

        return merge(left, right);
    }

    private List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getMark() <= right.get(j).getMark()) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }

    private void printSortedList(List<Student> studentList) {
        System.out.println("The student list has been sorted by marks:");
        for (Student student : studentList) {
            student.getStudent();
        }
    }
}
