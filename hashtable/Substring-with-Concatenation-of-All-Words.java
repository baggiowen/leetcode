public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (S.length() == 0 || L.length == 0) {
            return res;
        }
        int wordLen = L[0].length();
        int numOfWord = L.length;
        int size = wordLen * numOfWord;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> copy = null;
        for (String s : L) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
            else {
                map.put(s, 1);
            }
        }
        
        for (int i = 0; i < S.length(); i++) {
            if (i + size > S.length()) {
                break;
            }
            copy = new HashMap<String, Integer>(map);
            int j = i;
            while (j < i + size) {
                String substr = S.substring(j, j + wordLen);
                if (!copy.containsKey(substr)) {
                    break;
                }
                else {
                    copy.put(substr, copy.get(substr) - 1);
                    if (copy.get(substr) < 0) {
                        break;
                    }
                }
                j += wordLen;
            }
            if (j >= i + size) {
                res.add(i);
            }
        }
        return res;
    }
}

http://blog.csdn.net/whuwangyi/article/details/14641773
