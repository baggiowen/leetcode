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



public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs[0].length() == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() == 0) {
                return "";
            }
            int start = 0;
            while (start < res.length() && start < strs[i].length() && res.charAt(start) == strs[i].charAt(start)) {
                start++;
            }
            if (start == 0) {
                return "";
            }
            res = res.substring(0, start);
        }
        return res;
    }
}
