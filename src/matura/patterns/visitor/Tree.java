package matura.patterns.visitor;

import java.util.Iterator;
import java.util.LinkedList;

public class Tree implements Iterable<Integer>, VisitorAcceptor {
    Node root;

    public Tree() {
        this.root = null;
    }

    public void insert(int val) {
        Node node = new Node(val);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        while (true) {
            if (val < current.val) {
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

    public void insertRecursive(int val) {
        root = insertRecursive(val, root);
    }

    private Node insertRecursive(int val, Node node) {
        if (node == null) {
            return new Node(val);
        }

        if (val < node.val) {
            node.left = insertRecursive(val, node.left);
        } else {
            node.right = insertRecursive(val, node.right);
        }

        return node;
    }

    public void printInOrder() {
        printInOrder(root, 1);
    }

    private void printInOrder(Node node, int depth) {
        if (node == null) {
            return;
        }

        printInOrder(node.left, depth + 1);
        System.out.println(String.format("%1$" + depth * 2 + "s", "") + node.val);
        printInOrder(node.right, depth + 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                Node node = list.poll();
                assert node != null;
                if (node.left != null) list.add(node.left);
                if (node.right != null) list.add(node.right);
                return node.val;
            }
        };
    }

    @Override
    public int accept(Visitor visitor) {
        return root.accept(visitor);
    }
}
