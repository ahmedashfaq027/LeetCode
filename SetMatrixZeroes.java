/*

https://leetcode.com/problems/set-matrix-zeroes/

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
You must do it in place.

Constraints:
1. m == matrix.length
2. n == matrix[0].length
3. 1 <= m, n <= 200
4. -231 <= matrix[i][j] <= 231 - 1


Follow up:
1. A straightforward solution using O(mn) space is probably a bad idea.
2. A simple improvement uses O(m + n) space, but still not the best solution.
3. Could you devise a constant space solution?

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

*/

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        SetMatrixZeroes lc = new SetMatrixZeroes();

        int[][] tmp = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        lc.setZeroes(tmp);
        System.out.println(Arrays.deepToString(tmp));

        tmp = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        lc.setZeroes(tmp);
        System.out.println(Arrays.deepToString(tmp));
    }

    /*
        Explanation:
            Make the first value of row or column 0  if a certain cell has 0.
            While actually making rows/columns 0, we come from the bottom-right to make sure we don't disturb other cells.
    */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        int col0 = 1;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0)
                col0 = 0;

            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }

            if (col0 == 0)
                matrix[i][0] = 0;
        }
    }
}
