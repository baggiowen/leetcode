public class Solution {
    public int climbStairs(int n) {
        int[] res = new int[n + 1];
        return getResults(n, res);
    }
    
    public int getResults(int n, int[] res) {
        if (n <= 2) {
            res[n] = n;
            return n;
        } 
        if (res[n] != 0) {
            return res[n];
        }
        res[n] = getResults(n - 1, res) + getResults(n - 2, res);
        return res[n];
    }
}

//DP
