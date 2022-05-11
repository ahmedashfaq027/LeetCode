import java.util.Arrays;

public class Convert1DArrayInto2DArray {
    public static void main(String[] args) {
        Convert1DArrayInto2DArray lc = new Convert1DArrayInto2DArray();

        System.out.println(Arrays.deepToString(lc.construct2DArray(new int[]{1, 2, 3, 4}, 2, 2)));
        System.out.println(Arrays.deepToString(lc.construct2DArray(new int[]{1, 2, 3}, 1, 3)));
        System.out.println(Arrays.deepToString(lc.construct2DArray(new int[]{1, 2}, 1, 1)));
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        int len = original.length;

        if (len != m * n)
            return new int[][]{};

        int[][] res = new int[m][n];

        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[idx++];
            }
        }

        return res;
    }
}
