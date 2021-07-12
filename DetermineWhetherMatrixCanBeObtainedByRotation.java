import java.util.Arrays;

public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public static void main(String[] args) {
        DetermineWhetherMatrixCanBeObtainedByRotation lc = new DetermineWhetherMatrixCanBeObtainedByRotation();

        int[][] mat = new int[][]{
                {0, 1},
                {1, 0}
        };
        int[][] trgt = new int[][]{
                {1, 0},
                {0, 1}
        };

        System.out.println(lc.findRotation(mat, trgt));
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        if (Arrays.deepEquals(mat, target))
            return true;

        for (int i = 0; i < 4; i++) {
            rotate(mat);

            if (Arrays.deepEquals(mat, target))
                return true;
        }

        return false;
    }

    private void rotate(int[][] matrix) {
        // Transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[j][i] ^ (matrix[j][i] = matrix[i][j]);
            }
        }

        // Reverse
        for (int i = 0; i < matrix.length; i++) {
            int lo = 0, hi = matrix[i].length - 1;
            while (lo < hi) {
                matrix[i][hi] = matrix[i][hi] ^ matrix[i][lo] ^ (matrix[i][lo] = matrix[i][hi]);
                lo++;
                hi--;
            }
        }
    }
}
