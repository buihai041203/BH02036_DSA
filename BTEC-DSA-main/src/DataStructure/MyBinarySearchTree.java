package DataStructure;

class NodeTree {
    int value;
    NodeTree left;
    NodeTree right;

    public NodeTree(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}

public class MyBinarySearchTree {
    NodeTree root;

    public MyBinarySearchTree() {
        root = null;
    }

    public boolean contains(int value) {
        if (root == null) {
            return false;
        } else {
            NodeTree current = root;
            while (true) {
                if (current == null) {
                    return false;
                }
                if (value > current.value) {
                    current = current.right;
                } else if (value < current.value) {
                    current = current.left;
                } else {
                    return true;
                }
            }
        }
    }

    public boolean recursiveContains(int value) {
        return recursiveContains(root, value);
    }

    private boolean recursiveContains(NodeTree node, int value) {
        if (node == null) {
            return false;
        } else if (value == node.value) {
            return true;
        } else if (value > node.value) {
            return recursiveContains(node.right, value);
        } else {
            return recursiveContains(node.left, value);
        }
    }

    public void add(int value) {
        NodeTree newNode = new NodeTree(value);
        if (root == null) {
            root = newNode;
        } else {
            NodeTree current = root;
            while (true) {
                if (value < current.value) {
                    if (current.left == null) {
                        current.left = newNode;
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = newNode;
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    };

    public void insert(int value) {
        NodeTree newNode = new NodeTree(value);
        if (root == null) {
            root = newNode;
        } else {
            NodeTree current = root;
            while (true) {
                if (value < current.value) {
                    if (current.left == null) {
                        current.left = newNode;
                        break;
                    } else {
                        current = current.left;
                    }
                } else {
                    if (current.right == null) {
                        current.right = newNode;
                        break;
                    } else {
                        current = current.right;
                    }
                }
            }
        }
    }

    public void recursiveInsert(int value) {
        root = recursiveInsert(root, value);
    }

    private NodeTree recursiveInsert(NodeTree node, int value) {
        if (node == null) {
            node = new NodeTree(value);
        } else if (value > node.value) {
            node.right = recursiveInsert(node.right, value);
        } else if (value < node.value) {
            node.left = recursiveInsert(node.left, value);
        }
        return node;
    }

}