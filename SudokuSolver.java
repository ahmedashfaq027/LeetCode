/*

https://leetcode.com/problems/sudoku-solver/

Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:
1. Each of the digits 1-9 must occur exactly once in each row.
2. Each of the digits 1-9 must occur exactly once in each column.
3. Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
4. The '.' character indicates empty cells.

Constraints:
1. board.length == 9
2. board[i].length == 9
3. board[i][j] is a digit or '.'.
4. It is guaranteed that the input board has only one solution.

Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
    Explanation: The input board is shown above and the only valid solution is shown below:
    -------------------------
    | 5 3 . | . 7 . | . . . |
    | 6 . . | 1 9 5 | . . . |
    | . 9 8 | . . . | . 6 . |
    -------------------------
    | 8 . . | . 6 . | . . 3 |
    | 4 . . | 8 . 3 | . . 1 |
    | 7 . . | . 2 . | . . 6 |
    -------------------------
    | . 6 . | . . . | 2 8 . |
    | . . . | 4 1 9 | . . 5 |
    | . . . | . 8 . | . 7 9 |
    -------------------------

    -------------------------
    | 5 3 4 | 6 7 8 | 9 1 2 |
    | 6 7 2 | 1 9 5 | 3 4 8 |
    | 1 9 8 | 3 4 2 | 5 6 7 |
    -------------------------
    | 8 5 9 | 7 6 1 | 4 2 3 |
    | 4 2 6 | 8 5 3 | 7 9 1 |
    | 7 1 3 | 9 2 4 | 8 5 6 |
    -------------------------
    | 9 6 1 | 5 3 7 | 2 8 4 |
    | 2 8 7 | 4 1 9 | 6 3 5 |
    | 3 4 5 | 2 8 6 | 1 7 9 |
    -------------------------
*/

public class SudokuSolver {
    public static void main(String[] args) {
        SudokuSolver lc = new SudokuSolver();

        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        lc.printBoard(board);
        lc.solveSudoku(board);
        lc.printBoard(board);
    }

    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    private boolean dfs(char[][] board) {
        int[] resCell = findEmptyCell(board);

        if (resCell.length == 0)
            return true;

        int row = resCell[0], col = resCell[1];
        for (int i = 1; i <= 9; i++) {
            if (isSafe(board, row, col, (char) (i + '0'))) {
                board[row][col] = (char) (i + '0');
                if (dfs(board))
                    return true;
            }

            board[row][col] = '.';
        }

        return false;
    }

    private boolean isSafe(char[][] board, int row, int col, char ch) {
        if (isRowSafe(board, row, ch)
                && isColSafe(board, col, ch)
                && isGridSafe(board, row, col, ch)) {
            return true;
        }

        return false;
    }

    private boolean isRowSafe(char[][] board, int row, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch)
                return false;
        }

        return true;
    }

    private boolean isColSafe(char[][] board, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == ch)
                return false;
        }

        return true;
    }

    private boolean isGridSafe(char[][] board, int row, int col, char ch) {
        int r = row - (row % 3);
        int c = col - (col % 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + r][j + c] == ch)
                    return false;
            }
        }

        return true;
    }

    private int[] findEmptyCell(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    return new int[]{i, j};
            }
        }

        return new int[0];
    }

    private void printBoard(char[][] board) {
        int n = board.length, m = board[0].length;

        for (int j = 0; j < m + 4; j++) {
            System.out.print("--");
        }
        System.out.print("\n");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print((j == 0 ? "| " : "") + board[i][j] + ((j + 1) % 3 == 0 ? " | " : " "));
            }

            if ((i + 1) % 3 == 0) {
                System.out.print("\n");
                for (int j = 0; j < m + 4; j++) {
                    System.out.print("--");
                }
            }

            System.out.print("\n");
        }
    }
}
