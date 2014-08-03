public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            while (low < s.length() - 1 && !isAlphanumeric(s.charAt(low))) {
                low++;
            }
            while (high >= 0 && !isAlphanumeric(s.charAt(high))) {
                high--;
            }
            if (low >= high) {
                break;
            }
            if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high))) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    
    public boolean isAlphanumeric(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        else if (c >= '0' && c <= '9') {
            return true;
        }
        else {
            return false;
        }
    }
}
