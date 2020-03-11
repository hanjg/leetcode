package backtracking;

/**
 * problem-37 https://leetcode-cn.com/problems/sudoku-solver/
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    private boolean dfs(char[][] board) {
        //从(row,col)开始填数字,返回是否合理
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char put = '1'; put <= '9'; put++) {
                        if (isValid(board, i, j, put)) {
                            board[i][j] = put;
                            if (dfs(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j, char put) {
        for (int row = 0; row < 9; row++) {
            if (put == board[row][j]) {
                return false;
            }
        }
        for (int col = 0; col < 9; col++) {
            if (put == board[i][col]) {
                return false;
            }
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if (put == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
