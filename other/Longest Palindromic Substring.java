==========================================
first attempt - accepted, but not elegant
==========================================
public class Solution
{

  /**
   * @param args
   */
  
  public static String longestPalindrome(String s) {
    if (s.length() == 0) {
        return "";
    }
    if (s.length() == 1) {
        return s;
    }
    String result = "";
    int count1 = 1;
    int count2 = 1;
    int maxcount = 1;
    int count = 1;
    for (int i = 1; i < s.length(); i++) {
        int k = 1;
        int l = 1;
        if (s.charAt(i-1) == s.charAt(i)) {
            k = 2;
            count1 = 2;
        }
        while ((i-k > -1) && ((i+l) < s.length()) && (s.charAt(i-k) == s.charAt(i+l))) {
            k++;
            l++;
            count1 += 2;
        }
        if (i+1 < s.length()) {
          if (s.charAt(i-1) == s.charAt(i+1)) {
              count2 = 3;
              k = 2;
              l = 2;
          }
          while ((i-k > -1) && ((i+l) < s.length()) && (s.charAt(i-k) == s.charAt(i+l))) {
            k++;
            l++;
            count2 += 2;
            }
          }
        if (count1 > count2) {
            count = count1;
        }
        else {
            count = count2;
        }
        count1 = 1;
        count2 = 1;
        if (count > maxcount) {
            maxcount = count;
            if (count%2 == 0) {
                result = s.substring(i-count/2, i+count/2);
            }
            else {
                result = s.substring(i-count/2, i+count/2+1);
            }
        }
    }
    return result;
}

}

======================================
second attempt - more elegant
======================================
public class Solution
{

  /**
   * @param args
   */
  
  public String longestPalindrome(String s) {
      if (s == null || s.length() == 0) {
          return "";
      }
      String longest = "";
      for (int i = 0; i < s.length(); i++) {
          String temp = expend(s, i, i);
          if (temp.length() > longest.length()) {
              longest = temp;
          }
          temp = expend(s, i, i + 1);
          if (temp.length() > longest.length()) {
              longest = temp;
          }
      }
      return longest;
     
    }
    
    public String expend(String s, int c1, int c2) {
        while (c1 >= 0 && c2 < s.length() && s.charAt(c1) == s.charAt(c2)) {
            c1--;
            c2++;
        }
        return s.substring(c1 + 1, c2);
    }
}

//solution: expend each character to left and right
//key to make it elegant: use expend method to deal two expending cases
