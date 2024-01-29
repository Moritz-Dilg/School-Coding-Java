package matura.hashing.seperateChaining;

import java.util.NoSuchElementException;

public class HashTable {

    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.insert("abc", 3);
        ht.insert("abd", 4);
        ht.insert("abe", 5);
        ht.insert("abf", 6);
        System.out.println(ht.contains("abc"));
        System.out.println(ht.contains("abd"));
        System.out.println(ht.contains("abe"));
        System.out.println(ht.contains("abf"));
        System.out.println(ht.contains("abg"));
        System.out.println(ht.get("abc"));
        System.out.println(ht.get("abd"));
        System.out.println(ht.get("abe"));
        System.out.println(ht.get("abf"));
        System.out.println(ht.get("abg"));
    }

    private static final int TAB_SIZE = 8;
    private final Node[] table;

    public HashTable() {
        this.table = new Node[TAB_SIZE];
    }

    public void insert(String key, int value) {
        int idx = hash(key);
        if (table[idx] == null) {
            table[idx] = new Node(key, value, null);
        } else {
            Node p = table[idx];
            while (p != null && !p.key.equals(key)) {
                p = p.next;
            }
            if (p == null) {
                table[idx] = new Node(key, value, table[idx]);
            } else {
                p.value = value;
            }
        }
    }

    public boolean contains(String key) {
        int idx = hash(key);
        if (table[idx] == null) return false;
        Node p = table[idx];
        while (p != null && !p.key.equals(key)) p = p.next;
        return p != null;
    }

    public int get(String key) throws NoSuchElementException {
        int idx = hash(key);
        if (table[idx] == null) throw new NoSuchElementException(key + " not in HashTable!");
        Node p = table[idx];
        while (p != null && !p.key.equals(key)) p = p.next;
        if (p == null) throw new NoSuchElementException(key + " not in HashTable!");
        return p.value;
    }

    private int hash(String key) {
        int adr = 0;
        for (int i = 0; i < key.length(); i++) {
            adr = (2 * key.charAt(i)) % TAB_SIZE;
        }
        return adr;
    }

    private static class Node {
        private final String key;
        private int value;
        private final Node next;

        public Node(String key, int value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}