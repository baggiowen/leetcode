=======================================
First Attempt - TIMEOUT
=======================================
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
second attempt - accepted
======================================================
import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[] exist = new boolean[256];
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < s.length()) {
            if (!exist[s.charAt(j)]) {
                exist[s.charAt(j)] = true;
                j++;
            }
            else {
                count = Math.max(count, j - i);
                while (s.charAt(i) != s.charAt(j)) {
                    exist[s.charAt(i)] = false;
                    i++;
                }
                i++;
                j++;
            }
        }
        count = Math.max(count, j - i);
        return count;
 
    }
}

//use an array to store char existence
//requires only a one-time linear scan. O(n)
//need two indices to record the head and the tail of the current substring
//be careful with the last substring
