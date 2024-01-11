package recursion;

public class Array_11 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 123, 11, 11, 11};

        System.out.println(count_11(arr, 0));
    }

    static int count_11(int[] arr, int i) {
        if (i == arr.length - 1) return arr[i] == 11 ? 1 : 0;

        return count_11(arr, i + 1) + (arr[i] == 11 ? 1 : 0);
    }
}
