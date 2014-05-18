http://blog.csdn.net/linhuanmars/article/details/20343903

public class Solution {
    public String minWindow(String S, String T) {
        if (S.length() == 0 || T.length() == 0 || S.length() < T.length()) {
            return "";
        }
        int start = 0;
        String res = "";
        int count = 0;
        int minLen = S.length() + 1;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < T.length(); i++) {
            if (map.containsKey(T.charAt(i))) {
                map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
            }
            else {
                map.put(T.charAt(i), 1);
            }
        }
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), map.get(S.charAt(i)) - 1);
                if (map.get(S.charAt(i)) >= 0) {
                    count++;
                }
                while (count == T.length()) {
                    if (map.containsKey(S.charAt(start))) {
                        map.put(S.charAt(start), map.get(S.charAt(start)) + 1);
                        if (map.get(S.charAt(start)) > 0) {
                            count--;
                            if (i - start + 1 < minLen) {
                                minLen = i - start + 1;
                                res = S.substring(start, i + 1);
                            }
                        }
                    }
                    start++;
                }
            }
        }
        return res;
    }
}
