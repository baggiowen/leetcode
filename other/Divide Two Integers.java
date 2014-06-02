//http://blog.csdn.net/linhuanmars/article/details/20024907

//这题有点难 还没有完全掌握

public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        int res = 0;
        if(dividend == Integer.MIN_VALUE) {  
            res = 1;  
            dividend += Math.abs(divisor);
        }  
        if(divisor == Integer.MIN_VALUE) {
            return res;
        }
        boolean isNeg = ((dividend ^ divisor) >>> 31 == 1) ? true : false;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int digit = 0;
        while ((dividend >> 1) >= divisor) {
            divisor <<= 1;
            digit++;
        }
        while (digit >= 0) {
            if (dividend >= divisor) {
                dividend -= divisor;
                res += 1 << digit;
            }
            digit--;
            divisor >>= 1;
        }
        return isNeg ? -res : res;
    }
}
