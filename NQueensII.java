/*

https://leetcode.com/problems/n-queens-ii/

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Constraints:
1. 1 <= n <= 9

Input: n = 4
Output: 2
    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

    . Q . .
    . . . Q
    Q . . .
    . . Q .

    . . Q .
    Q . . .
    . . . Q
    . Q . .

Input: n = 1
Output: 1

*/

import java.util.HashSet;
import java.util.Set;

public class NQueensII {
    public static void main(String[] args) {
        NQueensII lc = new NQueensII();

        System.out.println(lc.totalNQueens(4));
        System.out.println(lc.totalNQueens(1));
    }

    public int totalNQueens(int n) {
        return backtrack(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int backtrack(int n, int row, Set<Integer> attackCols, Set<Integer> attackDiags, Set<Integer> attackAntiDiags) {
        if (row == n)
            return 1;

        int numQueensPlaced = 0;
        for (int col = 0; col < n; col++) {
            if (attackCols.contains(col) || attackDiags.contains(row - col) || attackAntiDiags.contains(row + col)) {
                continue;
            }

            attackCols.add(col);
            attackDiags.add(row - col);
            attackAntiDiags.add(row + col);

            numQueensPlaced += backtrack(n, row + 1, attackCols, attackDiags, attackAntiDiags);

            attackCols.remove(col);
            attackDiags.remove(row - col);
            attackAntiDiags.remove(row + col);
        }

        return numQueensPlaced;
    }

    int result;

    public int totalNQueensDFS(int n) {
        boolean[][] board = new boolean[n][n];
        result = 0;

        dfs(board, n, 0);

        return result;
    }

    private void dfs(boolean[][] board, int n, int row) {
        if (row == n) {
            result++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = true;
                dfs(board, n, row + 1);
                board[row][col] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int row, int col, int n) {
        for (int r = 0; r < n; r++) {
            if (board[r][col])
                return false;
        }

        for (int r = row - 1, c = col - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c])
                return false;
        }

        for (int r = row - 1, c = col + 1; r >= 0 && c < n; r--, c++) {
            if (board[r][c])
                return false;
        }

        return true;
    }

    private void printBoard(char[][] board) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
