package arrays;

import java.util.ArrayList;
import java.util.List;

public class Arrays {

    private static int[] split(int stones, int n_worker) {
        int[] worker = new int[n_worker];
        int x = stones / n_worker;
        java.util.Arrays.fill(worker, x);

        for (int i = 0; i < stones % n_worker && i < worker.length; i++) {
            worker[i]++;
        }

        return worker;
    }

    private static int[] prime_factorization(int x) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= x; i++) {
            while (x % i == 0) {
                factors.add(i);
                x /= i;
            }
        }

        int[] arr = new int[factors.size()];
        for (int i = 0; i < factors.size(); i++)
            arr[i] = factors.get(i);

        return arr;
    }

    private static int binarySearch(int[] arr, int _search) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int m = (low + high) / 2;
            if (arr[m] == _search) return m;
            else if (_search > arr[m]) low = m + 1;
            else high = m - 1;
        }
        return -1;
    }

    private static int simpleSearch(int[] arr, int _search) {
        int i;
        for (i = 0; i < arr.length && arr[i] != _search; i++) ;
        if (i >= arr.length) return -1;
        return i;
    }

    private static int[] invert(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    private static int[] bsp1(int length) {
        int[] array = new int[length];
        array[0] = 1;
        array[1] = 2;

        for (int i = 2; i < array.length; i++) {
            array[i] = array[i - 1] * array[i - 2];
        }

        return array;
    }
}
