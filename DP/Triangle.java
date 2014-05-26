http://www.programcreek.com/2013/01/leetcode-triangle-java/
http://fisherlei.blogspot.com/2013/01/leetcode-triangle.html

public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        int len = triangle.size() - 1;
        for (int i = 0; i < triangle.get(len).size(); i++) {
            dp[i] = triangle.get(len).get(i);
        }
        
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
