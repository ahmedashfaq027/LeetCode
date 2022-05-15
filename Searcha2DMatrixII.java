/*

https://leetcode.com/problems/search-a-2d-matrix-ii/

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
1. Integers in each row are sorted in ascending from left to right.
2. Integers in each column are sorted in ascending from top to bottom.

Constraints:
1. m == matrix.length
2. n == matrix[i].length
3. 1 <= n, m <= 300
4. -109 <= matrix[i][j] <= 109
5. All the integers in each row are sorted in ascending order.
6. All the integers in each column are sorted in ascending order.
7. -109 <= target <= 109

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false

*/

public class Searcha2DMatrixII {
    public static void main(String[] args) {
        Searcha2DMatrixII lc = new Searcha2DMatrixII();

        System.out.println(lc.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
        System.out.println(lc.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20));
        System.out.println(lc.searchMatrix(new int[][]{{}}, 20));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        // start from bottom-left corner
        int lo = n - 1, hi = 0;
        while (lo >= 0 && hi < m) {
            if (matrix[lo][hi] == target)
                return true;

            if (matrix[lo][hi] > target)
                lo--;
            else
                hi++;
        }

        return false;
    }

    public boolean searchMatrixBF(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target)
                    return true;
            }
        }

        return false;
    }
}
