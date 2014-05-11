http://fisherlei.blogspot.com/2012/12/leetcode-next-permutation.html

public class Solution {
    public void nextPermutation(int[] num) {
        if (num.length <= 1) {
            return;
        }
        int i = num.length - 2;
        while (i >= 0) {
            if (num[i] < num[i + 1]) {
                break;
            }
            i--;
        }
        if (i < 0) {
            reverse(num, 0, num.length - 1);
            return;
        }
        int j = num.length - 1;
        while (j > i) {
            if (num[j] > num[i]) {
                break;
            }
            j--;
        }
        int temp = num[j];
        num[j] = num[i];
        num[i] = temp;
        reverse(num, i + 1, num.length - 1);
    }
    
    public void reverse(int[] num, int begin, int end) {
        int left = begin;
        int right = end;
        while (left < right) {
            int temp = num[left];
            num[left] = num[right];
            num[right] = temp;
            left++;
            right--;
        }
    }
}
