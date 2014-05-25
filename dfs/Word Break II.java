http://stupidcodergoodluck.wordpress.com/2013/11/16/leetcode-word-break-ii/

public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() == 0) {
            return res;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        if (!dp[s.length()]) {
            return res;
        }
        StringBuilder path = new StringBuilder();
        dfs(s, dict, res, 0, path);
        return res;
    }
    
    public void dfs(String s, Set<String> dict, ArrayList<String> res, int start, StringBuilder path) {
        if (start >= s.length()) {
            res.add(path.toString());
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (dict.contains(s.substring(start, i + 1))) {
                int oldLen = path.length();
                if (oldLen != 0) {
                    path.append(" ");
                }
                path.append(s.substring(start, i + 1));
                dfs(s, dict, res, i + 1, path);
                path.delete(oldLen, path.length());
            }
        }
    }
}
