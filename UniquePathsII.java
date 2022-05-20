/*

https://leetcode.com/problems/unique-paths/

You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m-1][n-1]). The robot can only move either down or right at any point in time.
An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
    Explanation: There is one obstacle in the middle of the 3x3 grid above.
    There are two ways to reach the bottom-right corner:
    1. Right -> Right -> Down -> Down
    2. Down -> Down -> Right -> Right

Input: obstacleGrid = [[0,1],[0,0]]
Output: 1

Constraints:
1. m == obstacleGrid.length
2. n == obstacleGrid[i].length
3. 1 <= m, n <= 100
4. obstacleGrid[i][j] is 0 or 1.

*/

import java.util.Arrays;

public class UniquePathsII {
    public static void main(String[] args) {
        UniquePathsII lc = new UniquePathsII();

        System.out.println(lc.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(lc.uniquePathsWithObstacles(new int[][]{{0, 1}, {0, 0}}));
        System.out.println(lc.uniquePathsWithObstacles(new int[][]{{1}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0) ? dp[i - 1][0] : 0;
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = (obstacleGrid[0][i] == 0) ? dp[0][i - 1] : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }

        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstaclesRecursion(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(obstacleGrid, dp, 0, 0, m, n);
    }

    private int dfs(int[][] grid, int[][] dp, int i, int j, int m, int n) {
        if (!isValid(i, j, m, n, grid))
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (i == m - 1 && j == n - 1)
            return 1;

        return dp[i][j] = dfs(grid, dp, i + 1, j, m, n) + dfs(grid, dp, i, j + 1, m, n);
    }

    private boolean isValid(int i, int j, int m, int n, int[][] grid) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 1) {
            return false;
        }

        return true;
    }
}
