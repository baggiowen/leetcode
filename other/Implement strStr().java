public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle.length() == 0) {    //failed on first attempt
            return haystack;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.length() - i < needle.length()) {   //save time
                break;
            }
            int m = i;
            int n = 0;
            while (n < needle.length()) {
                if (haystack.charAt(m) != needle.charAt(n)) {
                    break;
                }
                m++;
                n++;
            }
            if (n == needle.length()) {
                return haystack.substring(i);
            }
        }
        return null;
    }
}

//quite straightforward
