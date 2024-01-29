package matura.hashing.quadraticProbing;


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

    private final int TAB_SIZE = 7;
    private final Node[] table;

    public HashTable() {
        this.table = new Node[TAB_SIZE];
    }

    public void insert(String key, int data) {
        int hash = hash(key);
        int d = -TAB_SIZE;

        while (table[hash] != null) {
            d += 2;
            hash = (hash + Math.abs(d)) % TAB_SIZE;
        }
        table[hash] = new Node(key, data);
    }

    public boolean contains(String key) {
        int hash = hash(key);
        int d = -TAB_SIZE;

        while (table[hash] != null && !table[hash].key.equals(key) && d <= TAB_SIZE) {
            d += 2;
            hash = (hash + Math.abs(d)) % TAB_SIZE;
        }
        return table[hash] != null;
    }

    public int get(String key) {
        int hash = hash(key);
        int d = -TAB_SIZE;

        while (table[hash] != null && !table[hash].key.equals(key) && d <= TAB_SIZE) {
            d += 2;
            hash = (hash + Math.abs(d)) % TAB_SIZE;
        }

        if (table[hash] != null)
            return table[hash].value;
        else throw new NoSuchElementException(key + " not in HashTable!");
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
