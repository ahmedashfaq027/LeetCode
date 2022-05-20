/*

https://leetcode.com/problems/unique-paths-iii/

You are given an m x n integer array grid where grid[i][j] could be:
1. 1 representing the starting square. There is exactly one starting square.
2. 2 representing the ending square. There is exactly one ending square.
3. 0 representing empty squares we can walk over.
4. -1 representing obstacles that we cannot walk over.

Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

Constraints:
1. m == grid.length
2. n == grid[i].length
3. 1 <= m, n <= 20
4. 1 <= m * n <= 20
5. -1 <= grid[i][j] <= 2
6. There is exactly one starting cell and one ending cell.

Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
    Explanation: We have the following two paths:
    1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
    2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)

Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
    Explanation: We have the following four paths:
    1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
    2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
    3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
    4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)

Input: grid = [[0,1],[2,0]]
Output: 0
    Explanation: There is no path that walks over every empty square exactly once.
    Note that the starting and ending square can be anywhere in the grid.

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
