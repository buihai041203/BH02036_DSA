package Models;

import Assignment.Student;

public class BST {
    private Node root;

    public class Node {
        Student student;
        Node left, right;

        public Node(Student student) {
            this.student = student;
            this.left = this.right = null;
        }
    }

    public BST() {
        this.root = null;
    }

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private Node insertRec(Node root, Student student) {
        if (root == null) {
            root = new Node(student);
            return root;
        }

        if (student.getId().compareTo(root.student.getId()) < 0) {
            root.left = insertRec(root.left, student);
        } else if (student.getId().compareTo(root.student.getId()) > 0) {
            root.right = insertRec(root.right, student);
        }
        return root;
    }

    public Student search(String id) {
        return searchRec(root, id);
    }

    private Student searchRec(Node root, String id) {
        if (root == null || root.student.getId().equals(id)) {
            return (root != null) ? root.student : null;
        }

        if (id.compareTo(root.student.getId()) < 0) {
            return searchRec(root.left, id);
        }
        return searchRec(root.right, id);
    }
}

