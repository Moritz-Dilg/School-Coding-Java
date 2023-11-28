package matura.patterns.visitor;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
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

        SumVisitor sumVisitor = new SumVisitor();
        System.out.println("Sum: " + tree.accept(sumVisitor));

        MaxVisitor maxVisitor = new MaxVisitor();
        System.out.println("Max: " + tree.accept(maxVisitor));

        MinVisitor minVisitor = new MinVisitor();
        System.out.println("Min: " + tree.accept(minVisitor));
    }
}
