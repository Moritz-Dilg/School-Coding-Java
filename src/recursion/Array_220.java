package recursion;

public class Array_220 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 20};

        System.out.println(array(arr, 0) ? "Found" : "Not found");
    }

    static boolean array(int[] arr, int i) {
        if (i == arr.length - 2) return arr[i] * 10 == arr[i + 1];
        return (arr[i] * 10 == arr[i + 1]) || array(arr, i + 1);
    }
}
