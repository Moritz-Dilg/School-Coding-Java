package hashing;

public class Hashmap {
    public static void main(String[] args) {
        Hashmap hashmap = new Hashmap();

        hashmap.print();
        hashmap.put("abc", new Data(3));
        hashmap.print();
        hashmap.put("abd", new Data(4));
        hashmap.print();
        hashmap.put("abe", new Data(5));
        hashmap.print();
        hashmap.put("abf", new Data(6));
        hashmap.print();

        System.out.println("Val at 'abd': " + hashmap.get("abd") + "\n");
        hashmap.print();

    }
    private final int tabSize = 7;
    private final Entry[] hashmap = new Entry[tabSize];

    public void put(String key, Data data) {
        int hash = Hashmap.hash(key) % this.tabSize;
        int d = -tabSize;

        while (hashmap[hash] != null) {
            d += 2;
            hash = (hash + Math.abs(d)) % tabSize;
        }

        hashmap[hash] = new Entry(key, data);
    }

    public Data get(String key) {
        int hash = Hashmap.hash(key) % this.tabSize;
        int d = -tabSize;

        while (hashmap[hash] != null && hashmap[hash].key.equals(key) && d <= tabSize) {
            d += 2;
            hash = (hash + Math.abs(d)) % tabSize;
        }

        if (hashmap[hash] != null)
            return hashmap[hash].data;
        else return null;
    }

    public void delete(String key) {
        int hash = Hashmap.hash(key) % this.tabSize;
        int d = -tabSize;

        while (hashmap[hash].key.equals(key)) {
            d += 2;
            hash = (hash + Math.abs(d)) % tabSize;
        }

        hashmap[hash] = null;
    }

    public void print() {
        System.out.println("[");
        for (Entry hashEntry : hashmap) {
            if (hashEntry != null)
                System.out.println(hashEntry);
            else System.out.println("null");
        }
        System.out.println("]\n");
    }

    static int hash(String key) {
        return key.length();
    }

    private static class Entry {
        String key;
        Data data;

        Entry(String key, Data data) {
            this.key = key;
            this.data = data;
        }

        public String toString() {
            return "Key: " + this.key + ", Data: " + this.data.toString();
        }
    }
}
