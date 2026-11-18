
package task8;

public class Main {

    public static void main(String[] args) {

        BST tree = new BST();
        int[] values = { 10, 5, 15, 3, 7, 12, 20, 6, 8 };

        for (int value : values) {
            tree.insert(value);
        }

        System.out.println("Елементи дерева:");
        tree.printTree();

        System.out.println("\nПошук елементів:");
        System.out.println("Чи є число 7: " + tree.isContained(7));
        System.out.println("Чи є число 100: " + tree.isContained(100));

        System.out.println("\nМінімальний елемент: " + tree.findMin());
        System.out.println("Максимальний елемент: " + tree.findMax());
        System.out.println("Кількість елементів: " + tree.count());

        System.out.println("\nВидалення числа 3:");
        tree.delete(3);
        tree.printTree();

        System.out.println("\nВидалення числа 7:");
        tree.delete(7);
        tree.printTree();

        System.out.println("\nВидалення числа 10:");
        tree.delete(10);
        tree.printTree();

        System.out.println("\nПісля видалення:");
        System.out.println("Кількість елементів: " + tree.count());
        System.out.println("Мінімальний елемент: " + tree.findMin());
        System.out.println("Максимальний елемент: " + tree.findMax());

        int[] remainingValues = { 5, 6, 8, 12, 15, 20 };

        for (int value : remainingValues) {
            tree.delete(value);
        }

        System.out.println("\nПісля очищення дерева:");
        tree.printTree();
        System.out.println("Кількість елементів: " + tree.count());
    }
}
