//一个数组中，假设数组大小为n，我们看所有数字二进制表示中第i个bit，全部加起来之和为m，那么m%3要么等于0，要么等于1。
//假设只出现一次的那个数字为X，那么当m%3=0是，X中对应的第i个bit为0，当m%3=1时，X中对应的第i个bit为1.

public class Solution {
    public int singleNumber(int[] A) {
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < A.length; j++) {
                count[i] += A[j]>>i & 1;    //找到第i位的bit之后 和1'与'一下，如果当前位是1，结果是就是1；如果是当前位是0，结果就是0
                count[i] %= 3;
            }
            result |= (count[i] << i);  //把每一位的结果拼接到result里去
        }
        return result;
    }
}
