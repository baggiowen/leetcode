=====================
first attempt
=====================
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[][] sum = new int[grid.length][grid[0].length];
        return getResult(grid, sum, grid.length - 1, grid[0].length - 1);
    }
    
    public int getResult(int[][] grid, int[][] sum, int i, int j) {
        if (i == 0 && j == 0) {
            sum[i][j] = grid[0][0];
            return sum[i][j];
        }
        if (sum[i][j] != 0) {
            return sum[i][j];
        }
        if (i - 1 < 0) {
            sum[i][j] = grid[i][j] + getResult(grid, sum, i, j - 1);
        }
        else if (j - 1 < 0) {
            sum[i][j] = grid[i][j] + getResult(grid, sum, i - 1, j);
        }
        else {
            sum[i][j] = grid[i][j] + Math.min(getResult(grid, sum, i, j - 1), getResult(grid, sum, i - 1, j));
        }
        return sum[i][j];
    }
}

//倒序recursive - DP

=============================
second attempt - more elegant
=============================
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int res[][] = new int[grid.length][grid[0].length];
        res[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    res[i][j] = grid[0][0];
                }
                else if (i - 1 < 0) {
                    res[i][j] = res[i][j - 1] + grid[i][j];
                }
                else if (j - 1 < 0) {
                    res[i][j] = res[i - 1][j] + grid[i][j];
                }
                else {
                    res[i][j] = Math.min(res[i][j - 1], res[i - 1][j]) + grid[i][j];
                }
            }
        }
        return res[grid.length - 1][grid[0].length - 1];
    }
}

//顺序
