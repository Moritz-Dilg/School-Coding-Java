package projects_5.graph;

import java.util.*;

public class Graph<T extends Comparable<T>> {
    private final ArrayList<Node<T>> nodes;

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();

        Node<Integer> a = graph.insert(1);
        Node<Integer> b = graph.insert(2, a, 5);
        Node<Integer> c = graph.insert(3, a, 3);
        Node<Integer> d = graph.insert(4, b, 2);
        Node<Integer> e = graph.insert(5, b, 1);
        Node<Integer> f = graph.insert(6, c, 2);
        Node<Integer> g = graph.insert(7, c, 3);
        Node<Integer> h = graph.insert(8, d, 6);
        graph.connect(f, h, 2);
        graph.connect(g, h, 1);
        graph.connect(e, h, 4);

        System.out.println("DFS: " + graph.dfs(8).getData());

        System.out.println("BFS: " + graph.bfs(8).getData());

        ArrayList<Node<Integer>> path = graph.dijkstra(a, h);
        System.out.println("Dijkstra: ");
        for (Node<Integer> node : path) {
            System.out.println(node.getData());
        }

        graph.mst();
        System.out.println("MST: ");
        for (Node<Integer> node : graph.getNodes()) {
            if (node.getDad() == null) continue;
            System.out.println(node.getData() + " <-(" + node.getMinWeight() + ")-> " + node.getDad().getData());
        }
    }

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public ArrayList<Node<T>> getNodes() {
        return nodes;
    }

    public Node<T> insert(T data) {
        Node<T> node = new Node<>(data);
        this.nodes.add(node);

        return node;
    }

    public void connect(Node<T> a, Node<T> b, int weight) {
        a.addSon(b, weight);
        b.addSon(a, weight);
    }

    public Node<T> insert(T data, Node<T> dad, int weight) {
        Node<T> node = insert(data);
        connect(node, dad, weight);

        return node;
    }

    public Node<T> dfs(T data) {
        return dfs(data, this.nodes.get(0));
    }

    public Node<T> dfs(T data, Node<T> node) {
        List<Node<T>> sons = node.getSons();

        for (Node<T> son : sons) {
            if (son.isMarked()) continue;
            if (son.getData().equals(data)) {
                resetMarked();
                return son;
            }

            son.setMarked(true);

            Node<T> result = dfs(data, son);
            if (result != null)
                return result;
        }

        resetMarked();
        return null;
    }

    public Node<T> bfs(T data) {
        return bfs(data, this.nodes.get(0));
    }

    public Node<T> bfs(T data, Node<T> start) {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            if (node.isMarked()) continue;
            if (node.getData().equals(data)) {
                resetMarked();
                return node;
            }

            node.setMarked(true);

            List<Node<T>> sons = node.getSons();
            queue.addAll(sons);
        }

        resetMarked();
        return null;
    }

    private void resetMarked() {
        for (Node<T> node : nodes) {
            node.setMarked(false);
        }
    }

    private void resetMinWeight() {
        for (Node<T> node : nodes) {
            node.setMinWeight(Integer.MAX_VALUE);
        }
    }

    public ArrayList<Node<T>> dijkstra(Node<T> a, Node<T> b) {
        ArrayList<Node<T>> path = new ArrayList<>();
        PriorityQueue<Node<T>> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getMinWeight));

        a.setMinWeight(0);
        queue.add(a);

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            node.setMarked(true);

            if (node.equals(b)) {
                Node<T> current = node;
                while (current != null) {
                    path.add(current);
                    current = current.getDad();
                }
                Collections.reverse(path);
                return path;
            }

            List<Node<T>> sons = node.getSons();
            List<Integer> weights = node.getWeights();

            for (int i = 0; i < sons.size(); i++) {
                Node<T> son = sons.get(i);
                int weight = weights.get(i);

                if (!son.isMarked()) {
                    int newWeight = node.getMinWeight() + weight;
                    if (newWeight < son.getMinWeight()) {
                        son.setMinWeight(newWeight);
                        son.setDad(node);
                        queue.add(son);
                    }
                }
            }
        }


        return null;
    }

    public void mst() {
        resetMarked();
        resetMinWeight();
        PriorityQueue<Node<T>> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getMinWeight));
        queue.add(this.nodes.get(0));

        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            node.setMarked(true);

            List<Node<T>> sons = node.getSons();
            List<Integer> weights = node.getWeights();

            for (int i = 0; i < sons.size(); i++) {
                Node<T> son = sons.get(i);
                int weight = weights.get(i);

                if (!son.isMarked()) {
                    if (weight < son.getMinWeight()) {
                        son.setMinWeight(weight);
                        son.setDad(node);
                        queue.add(son);
                    }
                }
            }

            node.removeAllSons();
            if (node.getDad() != null) connect(node, node.getDad(), node.getMinWeight());
        }
    }
}
