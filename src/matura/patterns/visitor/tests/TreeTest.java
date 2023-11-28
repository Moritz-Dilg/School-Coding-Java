package matura.patterns.visitor.tests;

import matura.patterns.visitor.Tree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TreeTest {
    Tree tree;

    @BeforeEach
    public void setUp() {
        tree = new Tree();
    }

    @Test
    public void testInsertRecursive1() {
        tree.insertRecursive(5);
        tree.insertRecursive(3);
        tree.insertRecursive(7);
        tree.insertRecursive(2);
        tree.insertRecursive(4);
        tree.insertRecursive(6);
        tree.insertRecursive(8);

        int[] result = {5, 3, 7, 2, 4, 6, 8};
        int i = 0;
        for (int val : tree) {
            Assertions.assertEquals(result[i++], val);
        }
    }

    @Test
    public void testInsertRecursive2() {
        tree.insertRecursive(1);
        tree.insertRecursive(2);
        tree.insertRecursive(3);
        tree.insertRecursive(4);
        tree.insertRecursive(5);
        tree.insertRecursive(6);
        tree.insertRecursive(7);

        int[] result = {1, 2, 3, 4, 5, 6, 7};
        int i = 0;
        for (int val : tree) {
            Assertions.assertEquals(result[i++], val);
        }
    }

    @Test
    public void testInsertRecursive3() {
        tree.insertRecursive(0);
        tree.insertRecursive(1);
        tree.insertRecursive(-1);

        int[] result = {0, -1, 1};
        int i = 0;
        for (int val : tree) {
            Assertions.assertEquals(result[i++], val);
        }
    }

    @Test
    public void testInsert1() {
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        int[] result = {5, 3, 7, 2, 4, 6, 8};
        int i = 0;
        for (int val : tree) {
            Assertions.assertEquals(result[i++], val);
        }
    }

    @Test
    public void testInsert2() {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);

        int[] result = {1, 2, 3, 4, 5, 6, 7};
        int i = 0;
        for (int val : tree) {
            Assertions.assertEquals(result[i++], val);
        }
    }

    @Test
    public void testInsert3() {
        tree.insert(0);
        tree.insert(1);
        tree.insert(-1);

        int[] result = {0, -1, 1};
        int i = 0;
        for (int val : tree) {
            Assertions.assertEquals(result[i++], val);
        }
    }
}
