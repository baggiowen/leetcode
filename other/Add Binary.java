public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() == 0 && b.length() == 0) {
            return "";
        }
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int extra = 0;
        while (i >= 0 || j >= 0 || extra > 0) {
            int num1 = i >= 0 ? Integer.parseInt(a.substring(i, i + 1)) : 0;
            int num2 = j >= 0 ? Integer.parseInt(b.substring(j, j + 1)) : 0;
            int res = num1 + num2 + extra;
            sb.insert(0, res % 2);
            extra = res / 2;
            i--;
            j--;
        }
        return sb.toString();
    }
}

//sb.insert(0, res % 2);
