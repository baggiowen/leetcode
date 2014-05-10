http://blog.csdn.net/linhuanmars/article/details/21145039

public class Solution {
    public String convert(String s, int nRows) {
        if (s == null || s.length() == 0 || nRows == 0) {
            return "";
        }
        if (nRows == 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int size = 2 * nRows - 2;
        for (int i = 0; i < nRows; i++) {
            int index = i;
            while (index < s.length()) {
                res.append(s.charAt(index)); //加入往下走的元素
                index += size;
                if (i != 0 && i != nRows - 1 && index - i - i < s.length()) { //加入往上走的元素，第一行和最后一行不用考虑
                    res.append(s.charAt(index - i - i));
                }
            }
        }
        return res.toString();
    }
}
