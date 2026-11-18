package task8;

public class BST {
    private Node root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    public boolean isContained(int value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }

        if (current.value == value) {
            return true;
        }

        if (value < current.value) {
            return containsRecursive(current.left, value);
        }

        return containsRecursive(current.right, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = deleteRecursive(current.right, value);
        } else {

            // нема нащадків
            if (current.left == null && current.right == null) {
                return null;
            }

            // тільки правий нащадок
            if (current.left == null) {
                return current.right;
            }

            // тільки лівий нащадок
            if (current.right == null) {
                return current.left;
            }

            // 2 нащадка
            Node minNode = findMinNode(current.right);

            current.value = minNode.value;

            current.right = deleteRecursive(
                    current.right, minNode.value);
        }

        return current;
    }

    private Node findMinNode(Node current) {
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Дерево порожнє.");
            return;
        }

        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(Node current) {
        if (current != null) {
            printInOrder(current.left);
            System.out.print(current.value + " ");
            printInOrder(current.right);
        }
    }

    public Integer findMin() {
        if (root == null) {
            return null;
        }

        return findMinNode(root).value;
    }

    public Integer findMax() {
        if (root == null) {
            return null;
        }

        Node current = root;

        while (current.right != null) {
            current = current.right;
        }

        return current.value;
    }

    public int count() {
        return countRecursive(root);
    }

    private int countRecursive(Node current) {
        if (current == null) {
            return 0;
        }

        return 1 + countRecursive(current.left)
                + countRecursive(current.right);
    }
}
