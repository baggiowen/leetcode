=============================
first attempt - naive
=============================
public class Solution {
    public int reverse(int x) {
        String num = String.valueOf(x);
        boolean negative = false;
        if (x < 0) {
            num = num.substring(1);
            negative = true;
        }
        char[] array = num.toCharArray();
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        num = new String(array);
        int i = 0;
        if (num.length() > 1 && num.charAt(0) == '0') {
            while (num.charAt(i) == '0') {
                i++;
            }
            num = num.substring(i);
        }
        int result = Integer.parseInt(num);
        if (negative) {
            return -result;
        }
        else {
            return result;
        }
    }
}

//solution: convert int to char array and do the reverse
//corner: 0, negative, overflow


===========================
second attempt - clever
===========================
public class Solution {
    public int reverse(int x){
    int r = 0;
    while(x != 0) {
        r = r*10 + x % 10;
        x /= 10;
    }
    return r;
    }
}
