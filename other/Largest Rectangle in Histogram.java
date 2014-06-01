//http://codeganker.blogspot.com/2014/03/largest-rectangle-in-histogram-leetcode.html

http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html

=======================
first attempt - O(n^2)
=======================
public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int curHeight = height[i];
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && height[left] >= curHeight) {
                left--;
            }
            left++;
            while (right < height.length && height[right] >= curHeight) {
                right++;
            }
            right--;
            int width = right - left + 1;
            max = Math.max(max, curHeight * width);
        }
        return max;
    }
}

