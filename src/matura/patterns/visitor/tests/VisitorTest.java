package matura.patterns.visitor.tests;

import matura.patterns.visitor.MaxVisitor;
import matura.patterns.visitor.MinVisitor;
import matura.patterns.visitor.SumVisitor;
import matura.patterns.visitor.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VisitorTest {
    Tree tree;
    @BeforeEach
    public void setUp() {
        tree = new Tree();
    }

    @Test
    public void testSumVisitor1() {
        tree.insertRecursive(5);
        tree.insertRecursive(3);
        tree.insertRecursive(7);
        tree.insertRecursive(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        SumVisitor sumVisitor = new SumVisitor();
        Assertions.assertEquals(35, tree.accept(sumVisitor));
    }

    @Test
    public void testMaxVisitor1() {
        tree.insertRecursive(5);
        tree.insertRecursive(3);
        tree.insertRecursive(7);
        tree.insertRecursive(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        MaxVisitor sumVisitor = new MaxVisitor();
        Assertions.assertEquals(8, tree.accept(sumVisitor));
    }

    @Test
    public void testMinVisitor1() {
        tree.insertRecursive(5);
        tree.insertRecursive(3);
        tree.insertRecursive(7);
        tree.insertRecursive(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        MinVisitor sumVisitor = new MinVisitor();
        Assertions.assertEquals(2, tree.accept(sumVisitor));
    }
}
