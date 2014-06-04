//http://blog.csdn.net/zxzxy1988/article/details/8586289
//int to char: (char)('0' + n)

public class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    
    public boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int n = 1; n <= 9; n++) {
                        board[i][j] = (char)('0' + n);
                        if (isValid(board, i, j) && helper(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int i, int j) {
        for (int n = 0; n < 9; n++) {
            if (n != i && board[n][j] == board[i][j]) {
                return false;
            }
        }
        
        for (int n = 0; n < 9; n++) {
            if (n != j && board[i][n] == board[i][j]) {
                return false;
            }
        }
        
        for (int n = 3 * (i / 3); n < 3 * (i / 3 + 1); n++) {
            for (int m = 3 * (j / 3); m < 3 * (j / 3 + 1); m++) {
                if (n != i && m != j && board[n][m] == board[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
