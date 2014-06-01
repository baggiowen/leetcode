//http://fisherlei.blogspot.com/2012/12/leetcode-gray-code.html

//移位运算符的使用： http://blog.csdn.net/lange253/article/details/4146680
//left-shift & right-shift

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for (int i = 1; i <= n; i++) {
            int len = res.size();
            int highestBit = 1 << (i - 1);
            for (int j = len - 1; j >= 0; j--) {
                res.add(res.get(j) + highestBit);
            }
        }
        return res;
    }
}
