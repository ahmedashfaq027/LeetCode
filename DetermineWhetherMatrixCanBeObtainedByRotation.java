/*

https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/

Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target by rotating mat in 90-degree increments, or false otherwise.

Constraints:
1. n == mat.length == target.length
2. n == mat[i].length == target[i].length
3. 1 <= n <= 10
4. mat[i][j] and target[i][j] are either 0 or 1.

Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
Output: true
    Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.

Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
Output: false
    Explanation: It is impossible to make mat equal to target by rotating mat.

Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
Output: true
    Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.

*/

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
