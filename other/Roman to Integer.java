public class Solution {
    public int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int sum = 0;
        sum += map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                sum -= map.get(s.charAt(i));
            } 
            else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }
}

//use a map
//从string的最后一位开始 如果当前位比当前位+1所代表的数字要小 sum-；反之sum+
