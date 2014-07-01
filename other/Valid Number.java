public class Solution {
    public boolean isNumber(String s) {
        return s.matches("^\\s*[+-]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)([eE][+-]?\\d+)?\\s*$");
    }
}

//http://leetcodenotes.wordpress.com/2013/11/23/leetcode-valid-number/
public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        if (s.length() > 0 && s.charAt(s.length() - 1) == 'e') {
            return false;
        }
        String[] tokens = s.split("e");
        if (tokens.length > 2) {
            return false;
        }
        boolean res = valid(tokens[0], false);
        if (tokens.length > 1) {
            res = res && valid(tokens[1], true);
        }
        return res;
    }
    
    public boolean valid(String s, boolean hasDot) {
        if ( s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-')) {
            s = s.substring(1);
        }
        if (s.length() == 0 || s.equals(".")) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                if (hasDot) {
                    return false;
                }
                else {
                    hasDot = true;
                }
            }
            else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}
