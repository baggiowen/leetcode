public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int res = 0;
        
        for (int i = 0; i < num.length; i++) {
            int l = i + 1;
            int r = num.length - 1;
            while (l < r) {
                int sum = num[i] + num[l] + num[r];
                int diff = Math.abs(sum - target);
                if (diff < min) {
                    min = diff;
                    res = sum;
                }
                if (sum <= target) {
                    l++;
                }
                else {
                    r--;
                }
            }
        }
        return res;
    }
}

//two pointers
