/*

https://leetcode.com/problems/word-search/

Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Constraints:
1. m == board.length
2. n = board[i].length
3. 1 <= m, n <= 6
4. 1 <= word.length <= 15
5. board and word consists of only lowercase and uppercase English letters.

Follow up: Could you use search pruning to make your solution faster with a larger board?

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

*/

public class WordSearch {
    public static void main(String[] args) {
        WordSearch lc = new WordSearch();

        System.out.println(lc.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        System.out.println(lc.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        System.out.println(lc.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }

    int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;

        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, n, m, 0, visited))
                        return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int n, int m, int idx, boolean[][] visited) {

        if (idx == word.length())
            return true;

        if (!isValid(i, j, n, m, visited) || board[i][j] != word.charAt(idx))
            return false;

        visited[i][j] = true;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (dfs(board, word, x, y, n, m, idx + 1, visited))
                return true;
        }
        visited[i][j] = false;

        return false;
    }

    private boolean isValid(int i, int j, int n, int m, boolean[][] vis) {
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j])
            return false;
        return true;
    }
}
