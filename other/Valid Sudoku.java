http://blog.csdn.net/u010500263/article/details/18905027

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = null;
        for (int i = 0; i < board.length; i++) {
            set = new HashSet<Character>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            set = new HashSet<Character>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.' && !set.add(board[j][i])) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set = new HashSet<Character>();
                for (int m = i * 3; m < i * 3 + 3; m++) {
                    for (int n = j * 3; n < j * 3 + 3; n++) {
                        if (board[m][n] != '.' && !set.add(board[m][n])) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

//use hashset
//examine row, colunmn, block respectively
