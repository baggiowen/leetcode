public class Solution {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.startsWith("0")) {
            return 0;
        }
        int[] res = new int[s.length() + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '0') {
                    return 0;
                }
            }
            else {
                res[i + 1] = res[i];
            }
            int temp = Integer.parseInt(s.substring(i - 1, i + 1));
            if (temp <= 26 && temp >= 10) {
                res[i + 1] += res[i - 1];
            }
        }
        return res[s.length()];
    }
}

//be very careful with 0
