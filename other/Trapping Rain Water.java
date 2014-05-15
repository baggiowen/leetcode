//http://fisherlei.blogspot.com/2013/01/leetcode-trapping-rain-water.html

public class Solution {
    public int trap(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int[] left = new int[A.length];
        int max = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                left[i] = A[i];
                max = A[i];
            }
            else {
                left[i] = max;
            }
        }
        int[] right = new int[A.length];
        max = -1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] > max) {
                right[i] = A[i];
                max = A[i];
            }
            else {
                right[i] = max;
            }
        }
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            int min = Math.min(left[i], right[i]);
            if (A[i] < min) {
                total += min - A[i];
            }
        }
        return total;
    }
}
