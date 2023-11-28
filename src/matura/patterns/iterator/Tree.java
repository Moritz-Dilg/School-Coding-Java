package matura.patterns.iterator;

import java.util.Iterator;
import java.util.LinkedList;

public class Tree<T extends Comparable<T>> implements Iterable<T> {
    Node<T> root;

    public Tree() {
        this.root = null;
    }

    public void insert(T val) {
        Node<T> node = new Node<>(val);
        if (root == null) {
            root = node;
            return;
        }
        Node<T> current = root;
        while (true) {
            if (val.compareTo(current.val) < 0) {
                if (current.left == null) {
                    current.left = node;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = node;
                    return;
                }
                current = current.right;
            }
        }
    }

    public void insertRecursive(T val) {
        root = insertRecursive(val, root);
    }

    private Node<T> insertRecursive(T val, Node<T> node) {
        if (node == null) {
            return new Node<>(val);
        }

        if (val.compareTo(node.val) < 0) {
            node.left = insertRecursive(val, node.left);
        } else {
            node.right = insertRecursive(val, node.right);
        }

        return node;
    }

    public void printInOrder() {
        printInOrder(root, 1);
    }

    private void printInOrder(Node<T> node, int depth) {
        if (node == null) {
            return;
        }

        printInOrder(node.left, depth + 1);
        System.out.println(String.format("%1$" + depth * 2 + "s", "") + node.val);
        printInOrder(node.right, depth + 1);
    }

    @Override
    public Iterator<T> iterator() {
        LinkedList<Node<T>> list = new LinkedList<>();
        list.add(root);
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public T next() {
                Node<T> node = list.poll();
                assert node != null;
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
                return node.val;
            }
        };
    }
}
