/*

https://leetcode.com/problems/unique-paths/

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

Constraints:
1. 1 <= m, n <= 100

Input: m = 3, n = 7
Output: 28

Input: m = 3, n = 2
Output: 3
    Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    1. Right -> Down -> Down
    2. Down -> Down -> Right
    3. Down -> Right -> Down

*/

public class UniquePathsIII {
    public static void main(String[] args) {
        UniquePathsIII lc = new UniquePathsIII();

        System.out.println(lc.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
        System.out.println(lc.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}));
        System.out.println(lc.uniquePathsIII(new int[][]{{0, 1}, {2, 0}}));
    }

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        int[] start = null, end = null;
        int obstacles = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    obstacles++;
                } else if (grid[i][j] == 1) {
                    start = new int[]{i, j};
                } else if (grid[i][j] == 2) {
                    end = new int[]{i, j};
                }
            }
        }

        int total = (m * n) - obstacles;
        if (start == null || end == null) {
            return 0;
        }

        return dfs(grid, dp, start[0], start[1], m, n, end, 1, total);
    }

    int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private int dfs(int[][] grid, int[][] dp, int i, int j, int m, int n, int[] end, int visitedCells, int total) {
        if (i == end[0] && j == end[1]) {
            if (visitedCells == total)
                return 1;
            return 0;
        }

        grid[i][j] = -1;
        int res = 0;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (isValidMove(x, y, m, n, grid)) {
                res += dfs(grid, dp, x, y, m, n, end, visitedCells + 1, total);
            }
        }
        grid[i][j] = 0;

        return res;
    }

    private boolean isValidMove(int i, int j, int m, int n, int[][] grid) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == -1)
            return false;
        return true;
    }
}
