package projects_5.bst;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        tree.traverse();

        System.out.println();
        System.out.println(tree.search(5).getValue());

        tree.delete(7);
        System.out.println("---Deleted 7---");
        tree.traverse();

        tree.delete(5);
        System.out.println("---Deleted 5---");
        tree.traverse();

        tree.delete(8);
        System.out.println("---Deleted 8---");
        tree.traverse();

        tree.balance();
        System.out.println("---Balanced---");
        tree.traverse();
    }

    public Tree() {
        this.root = null;
    }

    public Node<T> search(T value) {
        Node<T> current = this.root;

        while (current != null && current.getValue() != value) {
            if (value.compareTo(current.getValue()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        return current;
    }

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);

        if (this.root == null) {
            this.root = newNode;
            return;
        }

        Node<T> current = this.root;
        Node<T> parent = this.root;
        while (true) {
            if (value.compareTo(current.getValue()) < 0) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                    return;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    return;
                }
            }
            parent = current;
        }

    }

    public void delete(T value) {
        Node<T> parent = this.root;
        Node<T> current = this.root;

        while (current != null && current.getValue() != value) {
            parent = current;
            if (value.compareTo(current.getValue()) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }

        if (current == null) return;

        if (current.getRight() == null) {
            if (current == this.root) {
                this.root = current.getLeft();
            } else {
                if (parent.getLeft() == current) {
                    parent.setLeft(current.getLeft());
                } else {
                    parent.setRight(current.getLeft());
                }
            }
        } else {
            Node<T> leftMost = current.getRight();
            Node<T> leftMostParent = current;

            while (leftMost.getLeft() != null) {
                leftMostParent = leftMost;
                leftMost = leftMost.getLeft();
            }

            if (leftMostParent != current) {
                leftMostParent.setLeft(leftMost.getRight());
                leftMost.setLeft(current.getLeft());
                leftMost.setRight(current.getRight());

                if (current == root) {
                    root = leftMost;
                    return;
                }
                if (parent.getLeft() == current) {
                    parent.setLeft(leftMost);
                } else {
                    parent.setRight(leftMost);
                }
            } else {
                parent.setRight(leftMost);
                leftMost.setLeft(current.getLeft());
            }

        }
    }

    private void traverse(TraverseStrategy strategy, Node<T> node) {
        switch (strategy) {
            default:
            case IN_ORDER:
                if (node.getLeft() != null) traverse(strategy, node.getLeft());
                System.out.println(node.getValue());
                if (node.getRight() != null) traverse(strategy, node.getRight());
                break;
            case PRE_ORDER:
                if (node.getLeft() != null) traverse(strategy, node.getLeft());
                if (node.getRight() != null) traverse(strategy, node.getRight());
                System.out.println(node.getValue());
                break;
            case POST_ORDER:
                System.out.println(node.getValue());
                if (node.getLeft() != null) traverse(strategy, node.getLeft());
                if (node.getRight() != null) traverse(strategy, node.getRight());
                break;
        }
    }

    public void traverse(TraverseStrategy strategy) {
        traverse(strategy, root);
    }

    public void traverse() {
        traverse(TraverseStrategy.IN_ORDER, this.root);
    }

    public void balance() {
        treeToVine();
        vineToTree();
    }

    private void treeToVine() {
        Node<T> current = this.root;
        Node<T> parent = this.root;

        while (current != null) {
            if (current.getLeft() != null) {
                Node<T> temp = current.getLeft();
                current.setLeft(temp.getRight());
                temp.setRight(current);
                if (current == this.root) {
                    this.root = temp;
                    parent = this.root;
                } else {
                    parent.setRight(temp);
                }
                current = temp;
            } else {
                parent = current;
                current = current.getRight();
            }
        }
    }

    private void vineToTree() {
        Node<T> current = this.root;
        int n = 0;
        while (current != null) {
            current = current.getRight();
            n++;
        }


        int k = 1;
        while (k <= n + 1) k = k + k;
        int i = k / 2 - 1;

        Node<T> nRoot = new Node<>(null);
        nRoot.setRight(root);
        compress(root, n - i);
        while (i > 1) {
            i /= 2;
            compress(nRoot, i);
        }

        this.root = nRoot.getRight();
    }

    private void compress(Node<T> root, int count) {
        Node<T> current = root;
        for (int i = 0; i < count; i++) {
            Node<T> child = current.getRight();
            current.setRight(child.getRight());
            current = current.getRight();
            child.setRight(current.getLeft());
            current.setLeft(child);
        }
    }
}
