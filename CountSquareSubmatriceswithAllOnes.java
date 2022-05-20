/*

https://leetcode.com/problems/count-square-submatrices-with-all-ones/

Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

Constraints:
1. 1 <= arr.length <= 300
2. 1 <= arr[0].length <= 300
3. 0 <= arr[i][j] <= 1

Input: matrix =
        [
          [0,1,1,1],
          [1,1,1,1],
          [0,1,1,1]
        ]
Output: 15
    Explanation:
    There are 10 squares of side 1.
    There are 4 squares of side 2.
    There is  1 square of side 3.
    Total number of squares = 10 + 4 + 1 = 15.

Input: matrix =
        [
          [1,0,1],
          [1,1,0],
          [1,1,0]
        ]
Output: 7
    Explanation:
    There are 6 squares of side 1.
    There is 1 square of side 2.
    Total number of squares = 6 + 1 = 7.

*/

public class CountSquareSubmatriceswithAllOnes {
    public static void main(String[] args) {
        CountSquareSubmatriceswithAllOnes lc = new CountSquareSubmatriceswithAllOnes();

        System.out.println(lc.countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}));
        System.out.println(lc.countSquares(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}}));
    }

    /*
        Explanation:
            This problem is very similar to "Largest Square" where we can use DP by applying a window of size 2.
            For window:     1 1         1 1
                            1 1    =>   1 2
            We take minimum of (0, 0), (0, 1), (1, 0) and add 1 to it. and we make BRHS (Bottom Right Hand Size) cell to this value.
            In this problem, we have to add all of the BRHS for all windows.
    */
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        if (m < 2 || n < 2) {
            int sum = 0;
            for (int[] i : matrix)
                for (int j : i)
                    sum += j;

            return sum;
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    int topLeft = matrix[i - 1][j - 1];
                    int top = matrix[i - 1][j];
                    int left = matrix[i][j - 1];
                    int curr = matrix[i][j];

                    if (isMatrixValid(topLeft, top, left, curr)) {
                        matrix[i][j] = min(topLeft, top, left) + 1;
                    }
                }

                res += matrix[i][j];
            }
        }

        return res;
    }

    private boolean isMatrixValid(int topLeft, int top, int left, int curr) {
        if (topLeft >= 1 && top >= 1 && left >= 1 && curr >= 1)
            return true;
        return false;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
