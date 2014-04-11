public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (!strs[i].startsWith(res)) {
                res = res.substring(0, res.length() - 1);
            }
            if (res == "") {
                return "";
            }
        }
        return res;
    }
}
