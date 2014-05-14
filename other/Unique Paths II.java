//DP
//a bit change on Unique Path
//be careful with corner cases

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (i == 0 && j == 0) {
                    if (obstacleGrid[0][0] == 1) {
                        return 0;
                    }
                    else {
                        res[0][0] = 1;
                    }
                }
                else {
                    if (obstacleGrid[i][j] == 1) {
                        res[i][j] = 0;
                    }
                    else {
                        if (i == 0) {
                            res[i][j] = res[i][j - 1];
                        }
                        else if (j == 0) {
                            res[i][j] = res[i - 1][j];
                        }
                        else {
                            res[i][j] = res[i - 1][j] + res[i][j - 1];
                        }
                    }
                }
            }
        }
        return res[res.length - 1][res[0].length - 1];
    }
}
