public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.length() == 0) {
            return false;
        }
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (res[j] && dict.contains(s.substring(j, i))) {
                    res[i] = true;
                }
            }
        }
        return res[s.length()];
    }
}
