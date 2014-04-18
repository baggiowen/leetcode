public class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int[][] res = new int[n][n];
        
        int x = 0;
        int y = 0;
        int num = 1;
        while (n > 0) {
            if (n == 1) {
                res[x][y] = num;
                break;
            }
            for (int i = 0; i < n - 1; i++) {
                res[x][y++] = num++;
            }
            for (int i = 0; i < n - 1; i++) {
                res[x++][y] = num++;
            }
            for (int i = 0; i < n - 1; i++) {
                res[x][y--] = num++;
            }
            for (int i = 0; i < n - 1; i++) {
                res[x--][y] = num++;
            }
            x++;
            y++;
            n -= 2;
        }
        return res;
    }
}

//similar to Spiral Matrix
