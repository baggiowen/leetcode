public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if (n == 0) {
            res.add("");
        }
        else {
            ArrayList<String> prev = generateParenthesis(n - 1);
            for (String item : prev) {
                String s = "()" + item;
                if (!res.contains(s)) {
                    res.add(s);
                }
                for (int i = 0; i < item.length(); i++) {
                    if (item.charAt(i) == '(') {
                        s = item.substring(0, i + 1) + "()" + item.substring(i + 1, item.length());
                        if (!res.contains(s)) {
                            res.add(s);
                        }
                    }
                }
            }
        }
        return res;
    }
}

//classic recursive
