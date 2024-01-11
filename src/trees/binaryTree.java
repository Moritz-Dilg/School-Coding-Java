package trees;

public class binaryTree {
    public static void main(String[] args) {
        Tree t = new Tree();
        // ...
    }

    static class Tree {
        Node root;

        Tree() {
            this.root = null;
        }

        /*--Search--*/
        Node search_iterative(int val) {
            Node p = this.root;

            while (p != null) {
                if (p.value == val)
                    return p;

                if (p.value < val)
                    p = p.left;
                else
                    p = p.right;
            }

            return null;
        }

        Node search_recursive(int val) {
            return search(this.root, val);
        }

        static Node search(Node p, int val) {
            if (p == null || p.value == val)
                return p;
            else if (val < p.value)
                return search(p.left, val);
            else
                return search(p.right, val);
        }


        /*--Insert*/
        void insert_iterative(int val) {
            Node p = this.root;
            Node father = null;

            while (p != null) {
                father = p;

                if (val == p.value)
                    p = p.left;
                else
                    p = p.right;
            }

            Node n = new Node(val);

            if (father == null)
                this.root = n;
            else if (val < father.value)
                father.left = n;
            else
                father.right = n;
        }

        void insert_recursive(int val) {
            insert(this.root, val);
        }

        static Node insert(Node p, int val) {
            if (p == null)
                p = new Node(val);
            else if (val < p.value)
                p.left = insert(p.left, val);
            else
                p.right = insert(p.right, val);

            return p;
        }

        /*--Delete--*/
        Node delete(int val) {
            Node father = null;
            Node p = this.root;

            while (p != null && p.value != val) {
                father = p;
                if (val < p.value)
                    p = p.left;
                else
                    p = p.right;
            }

            if (p != null) {
                Node x;

                if (p.right == null) x = p.left;
                else if (p.right.left == null) {
                    x = p.right;
                    x.left = p.left;
                } else {
                    Node xf = p.right;
                    x = xf.left;

                    while (x.left != null) {
                        xf = x;
                        x = x.left;
                    }

                    xf.left = x.right;
                    x.left = p.left;
                    x.right = p.right;
                }

                if (p == root) root = x;
                else if (val < father.value) father.left = x;
                else father.right = x;

                p.left = null;
                p.right = null;
            }
            return p;
        }
    }

    static class Node {
        int value;
        Node left;
        Node right;

        Node(int val) {
            this.value = val;
            this.left = null;
            this.right = null;
        }
    }
}

