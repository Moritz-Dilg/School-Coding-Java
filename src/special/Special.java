package special;

import java.util.Arrays;

public class Special {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {2, 3, 4, 5}, {6, 7, 8, 9}};

        printRowByRow(arr);
        printColumnByColumn(arr);

        System.out.println("Row Sums");
        int[] rowSum = getRowSums(arr);
        for (int j : rowSum) {
            System.out.print(j + ", ");
        }

        System.out.println("\n\nColumn Sums");
        int[] columnSum = getColumnSums(arr);
        for (int j : columnSum) {
            System.out.print(j + ", ");
        }

        pascalschesDreieck();

        System.out.println("\nTranspose");
        printRowByRow(transpose(arr));
    }

    public static void printRowByRow(int[][] a) {
        System.out.println("Row by row");
        for(int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print(a[j][i]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printColumnByColumn(int[][] a) {
        System.out.println("Column by column");
        for(int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[] getRowSums(int[][] a) {
        int [] sum = new int[a[0].length];
        for(int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                sum[i] += a[j][i];
            }
        }

        return sum;
    }

    public static int[] getColumnSums(int[][] a) {
        int [] sum = new int[a.length];
        for(int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                sum[i] += a[i][j];
            }
        }

        return sum;
    }

    public static void pascalschesDreieck() {
        System.out.println("\n\nPascalsches Dreieck");
        int[] row = new int[]{1};
        for (int i = 0; i < 5; i++) {
            System.out.println(Arrays.toString(row));
            row = computeRow(row);
        }
    }

    public static int[] computeRow(int[] row) {
        int [] nRow = new int[row.length + 1];
        for (int i = 0; i < row.length - 1; i++) {
            nRow[i+1] = row[i] + row[i + 1];
        }
        nRow[0] = 1;
        nRow[row.length] = 1;
        return nRow;
    }

    public static int[][] transpose(int[][] a) {
        int [][] nA = new int[a[0].length][a.length];

        for(int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                nA[i][j] = a[j][i];
            }
        }

        return nA;
    }
}