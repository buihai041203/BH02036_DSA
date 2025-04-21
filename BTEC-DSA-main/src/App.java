
import DataStructure.MyBinarySearchTree;

// import package

public class App {
    public static void main(String[] args) throws Exception {
        // String csvFile = "student.csv";
        // List<Student> students = readCSV.csvToArray(csvFile);
        // for (Student student : students) {
        // student.print();
        // }
        // System.out.println(students.size());
        MyBinarySearchTree btsTree = new MyBinarySearchTree();
        btsTree.recursiveInsert(40);
        btsTree.recursiveInsert(20);
        btsTree.recursiveInsert(50);
        btsTree.recursiveInsert(60);
        btsTree.recursiveInsert(10);
        btsTree.recursiveInsert(20);
        btsTree.recursiveInsert(30);
        btsTree.recursiveInsert(60);
        btsTree.recursiveInsert(70);
        btsTree.recursiveInsert(65);
        // System.out.println(btsTree.contains(80));
        System.out.println(btsTree.recursiveContains(80));
    }
}
