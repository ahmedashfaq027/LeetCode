/*

https://leetcode.com/problems/number-of-islands/

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Constraints:
1. m == grid.length
2. n == grid[i].length
2. 1 <= m, n <= 300
4. grid[i][j] is '0' or '1'.

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

*/

public class NumberofIslands {
    public static void main(String[] args) {
        NumberofIslands lc = new NumberofIslands();

        System.out.println(lc.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        System.out.println(lc.numIslands(new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;

        int res = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, visited, i, j, n, m);
                    res++;
                }
            }
        }

        return res;
    }

    int[][] dir = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private void dfs(char[][] grid, boolean[][] visited, int i, int j, int n, int m) {
        if (!isValid(i, j, n, m, visited) || grid[i][j] == '0')
            return;

        visited[i][j] = true;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            dfs(grid, visited, x, y, n, m);
        }
    }

    private boolean isValid(int i, int j, int n, int m, boolean[][] vis) {
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j])
            return false;
        return true;
    }
}
