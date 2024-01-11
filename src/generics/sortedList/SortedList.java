package generics.sortedList;

import java.util.Iterator;

public class SortedList<T extends Comparable<T>> implements Iterable<T> {
    private T[] data;
    private int nElements = 0;

    public void add(T el) {
        int i = nElements - 1;
        while (i >= 0 && el.compareTo(data[i]) > 0) {
            data[i + 1] = data[i];
            i--;
        }
        data[i + 1] = el;
        nElements++;
    }

    public void remove(T el) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(el)) {
                for (int j = 0; j < data.length - 1; j++) {
                    data[j] = data[j + 1];
                }
                return;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            final int curr = 0;

            @Override
            public boolean hasNext() {
                return curr < data.length;
            }

            @Override
            public T next() {
                return data[curr];
            }
        };
    }
}
