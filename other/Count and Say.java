http://blog.csdn.net/fightforyourdream/article/details/12901505

public class Solution {
    public String countAndSay(int n) {
        if (n == 1) { 
            return "1";
        }
        String res = "1";
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int round = 1;
        while (round < n) {
            count = 1;
            sb = new StringBuilder();
            for (int i = 1; i < res.length(); i++) {
                if (res.charAt(i) == res.charAt(i - 1)) {
                    count++;
                }
                else {
                    sb.append(count).append(res.charAt(i - 1));
                    count = 1;
                }
            }
            sb.append(count).append(res.charAt(res.length() - 1));
            res = sb.toString();
            round++;
        }
        return res;
    }
}
