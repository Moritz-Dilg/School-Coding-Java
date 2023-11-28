package matura.patterns.iterator;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.insertRecursive(5);
        tree.insertRecursive(3);
        tree.insertRecursive(7);
        tree.insertRecursive(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);
        tree.printInOrder();

        for (int val : tree) {
            System.out.println(val);
        }
    }
}
