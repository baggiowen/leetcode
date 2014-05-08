********************
Symbol	Value
  I	      1
  V	      5
  X	      10
  L	      50
  C	      100
  D	      500
  M	      1,000
********************

public class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int i = 0;
        while (num > 0) {
            int times = num / nums[i];
            num -= times * nums[i];
            for (int j = 0; j < times; j++) {
                sb.append(symbols[i]);
            }
            i++;
        }
        return sb.toString();
    }
}

//put special cases together with normal symbols
