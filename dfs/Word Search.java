public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word.length() == 0) {
            return false;
        }
        
        if (word.length() > board.length * board[0].length) {
            return false;
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word.substring(1), i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, String word, int i, int j) {
        if (word.length() == 0) {
            return true;
        }
        
        char c = word.charAt(0);
        char temp = board[i][j];
        String leftover = word.substring(1);
        
        if (i - 1 >= 0 && board[i - 1][j] == c) {
            board[i][j] = '.';
            if (helper(board, leftover, i - 1, j)) {
                return true;
            }
            board[i][j] = temp;
        }
        
        if (i + 1 < board.length && board[i + 1][j] == c) {
            board[i][j] = '.';
            if (helper(board, leftover, i + 1, j)) {
                return true;
            }
            board[i][j] = temp;
        }
        
        if (j - 1 >= 0 && board[i][j - 1] == c) {
            board[i][j] = '.';
            if (helper(board, leftover, i, j - 1)) {
                return true;
            }
            board[i][j] = temp;
        }
        
        if (j + 1 < board[0].length && board[i][j + 1] == c) {
            board[i][j] = '.';
            if (helper(board, leftover, i, j + 1)) {
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }
}
