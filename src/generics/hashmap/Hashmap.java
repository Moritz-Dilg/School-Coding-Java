package generics.hashmap;

public class Hashmap<K, V> {
    private final int tabSize = 7;
    private final Entry<K, V>[] hashmap = (Entry<K, V>[]) new Object[tabSize];

    public void put(K key, V data) {
        int hash = hash(key) % this.tabSize;
        int d = -tabSize;

        while (hashmap[hash] != null) {
            d += 2;
            hash = (hash + Math.abs(d)) % tabSize;
        }

        hashmap[hash] = new Entry<>(key, data);
    }

    public V get(K key) {
        int hash = hash(key) % this.tabSize;
        int d = -tabSize;

        while (hashmap[hash] != null && hashmap[hash].key.equals(key) && d <= tabSize) {
            d += 2;
            hash = (hash + Math.abs(d)) % tabSize;
        }

        if (hashmap[hash] != null)
            return hashmap[hash].data;
        else return null;
    }

    public void delete(K key) {
        int hash = hash(key) % this.tabSize;
        int d = -tabSize;

        while (hashmap[hash].key.equals(key)) {
            d += 2;
            hash = (hash + Math.abs(d)) % tabSize;
        }

        hashmap[hash] = null;
    }

    public void print() {
        System.out.println("[");
        for (Entry<K, V> hashEntry : hashmap) {
            if (hashEntry != null)
                System.out.println(hashEntry);
            else System.out.println("null");
        }
        System.out.println("]\n");
    }

    private int hash(K key) {
        return key.hashCode();
    }

    private static class Entry<K, V> {
        K key;
        V data;

        Entry(K key, V data) {
            this.key = key;
            this.data = data;
        }

        public String toString() {
            return "Key: " + this.key + ", Data: " + this.data.toString();
        }
    }
}
