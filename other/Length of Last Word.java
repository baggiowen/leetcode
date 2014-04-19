public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int count = 0;
        int j = s.length() - 1;
        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        }
        for (int i = j; i >=0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            }
            else {
                break;
            }
        }
        return count;
    }
}

//don't forget the case such that "xxx     "
