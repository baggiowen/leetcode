==================First Attempt=====================
import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int resultLength = 1;
        int count = 1;
        ArrayList<Character> list = new ArrayList<Character>();
        list.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
                count++;
                if (count > resultLength) {
                    resultLength = count;
                }
            }
            else {
                list = new ArrayList<Character>();
                i = i - count + 1;
                list.add(s.charAt(i));
                count = 1;
            }
        }
        return resultLength;
    }
}

//TIMEOUT
//solution: use a list/hashmap to store the previous characters
//be careful: i = i - count + 1;
======================================================
