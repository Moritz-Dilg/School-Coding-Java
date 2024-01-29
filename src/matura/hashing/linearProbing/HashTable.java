package matura.hashing.linearProbing;

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
        for (int i = 0; i < table.length; i++) {
            if (table[(i + idx) % table.length] == null) {
                table[(i + idx) % table.length] = new Node(key, value);
                return;
            }
        }

        throw new IllegalStateException("Table is full!");
    }

    public boolean contains(String key) {
        int idx = hash(key);

        for (int i = 0; i < table.length; i++) {
            if (table[(i + idx) % table.length] == null) {
                return false;
            } else if (table[(i + idx) % table.length].key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public int get(String key) throws NoSuchElementException {
        int idx = hash(key);

        for (int i = 0; i < table.length; i++) {
            if (table[(i + idx) % table.length] == null) {
                throw new NoSuchElementException(key + " not in HashTable!");
            } else if (table[(i + idx) % table.length].key.equals(key)) {
                return table[(i + idx) % table.length].value;
            }
        }

        throw new NoSuchElementException(key + " not in HashTable!");
    }

    private int hash(String key) {
        int adr = 0;
        for (int i = 0; i < key.length(); i++) {
            adr = (2 * key.charAt(i)) % TAB_SIZE;
        }
        return adr;
    }

    private record Node(String key, int value) {
    }
}