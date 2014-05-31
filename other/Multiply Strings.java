http://blog.csdn.net/fightforyourdream/article/details/17370495

public class Solution {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        
        int[] res = new int[num1.length() + num2.length()];
        
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                res[i + j] += a * b;
            }
        }
        
        int carry = 0;
        int digit = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            digit = res[i] % 10;
            carry = res[i] / 10;
            sb.insert(0, digit);
            if (i < res.length - 1) {
                res[i + 1] += carry;
            }
        }
        
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
