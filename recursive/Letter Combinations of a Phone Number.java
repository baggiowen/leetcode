======================
classic recursive
======================

public class Solution {
    String[] map = {"", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public ArrayList<String> letterCombinations(String digits) {
        return getResults(digits, digits.length() - 1);
    }
    
    public ArrayList<String> getResults(String digits, int index) {
        ArrayList<String> res = new ArrayList<String>();
        if (index < 0) {
            res.add("");
            return res;
        }
        ArrayList<String> temp = getResults(digits, index - 1);
        String code = map[Integer.parseInt(digits.substring(index, index + 1))];
        for (String s : temp) {
            for (int i = 0; i < code.length(); i++) {
                String s1 = s + code.substring(i, i + 1);
                res.add(s1);
            }
        }
        return res;
    }
}
