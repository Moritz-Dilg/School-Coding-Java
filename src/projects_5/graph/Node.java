package projects_5.graph;

import java.util.ArrayList;
import java.util.List;

public class Node<T extends Comparable<T>> {
    private final T data;
    private boolean marked;
    private final List<Node<T>> sons;
    private final List<Integer> weight;
    private Node<T> dad;
    private int minWeight;

    public Node(T data) {
        this.data = data;
        this.marked = false;
        this.sons = new ArrayList<>();
        this.weight = new ArrayList<>();
        this.dad = null;
        this.minWeight = Integer.MAX_VALUE;
    }

    public T getData() {
        return data;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public List<Node<T>> getSons() {
        return sons;
    }

    public List<Integer> getWeights() {
        return weight;
    }

    public Node<T> getDad() {
        return dad;
    }

    public void setDad(Node<T> dad) {
        this.dad = dad;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }

    public void addSon(Node<T> son, int weight) {
        this.sons.add(son);
        this.weight.add(weight);
    }

    public void removeAllSons() {
        this.sons.clear();
        this.weight.clear();
    }
}
