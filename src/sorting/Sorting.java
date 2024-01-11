package sorting;

public class Sorting {
    /* Select sort
     *
     * Das Array wird in einen sortierten und unsortierten Teil aufgeteilt.
     * Das kleinste Element aus dem unsortierten Teil wird zum sortierten Teil hinzugefügt
     *
     * Runtime complexity:
     *   Problemgröße: arr.length = n
     *   günstigster = ungünstigster = durchschnittlicher Fall
     *       t(n) = n * (n/2 + 1) = n^2 / 2 + n
     *       O(n^2)
     */
    public static void select_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[smallest] > arr[j]) {
                    smallest = j;
                }
            }
            if (smallest != i) {
                int temp = arr[smallest];
                arr[smallest] = arr[i];
                arr[i] = temp;
            }
        }
    }

    /* Insert sort
     *
     * Ein Element wird nach dem anderen in das sortierte
     * Array an der richtigen Stelle eingefügt
     *
     * Runtime complexity:
     *   Problemgröße: arr.length = n
     *   günstigster Fall:
     *       t(n) = n
     *       O(n)
     *   ungünstigster Fall: "verkehrt rum" sortiert
     *       t(n) = n * n/2 = n^2 / 2
     *       O(n^2)
     *   durchschnittlicher Fall:
     *       t(n) = n * n/4 = n^2 / 4
     *       O(n^2)
     */
    public static void insert_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }


    /* Bubble sort
     *
     * Die größten Elemente werden immer nach oben geschoben,
     * wie Luftblasen im Wasser, daher "Bubble sort"
     *
     * Runtime complexity:
     *   Problemgröße: arr.length = n
     *   günstigster = ungünstigster = durchschnittlicher Fall, weil wir nie vorzeitig die Schleife beenden.
     *   t(n) = n * n/2 = n^2 / 2
     *   O(n^2)
     */
    public static void bubble_sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
