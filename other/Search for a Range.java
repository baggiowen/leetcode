public class Solution {
    public int[] searchRange(int[] A, int target) {
        int lower = 0;
        int upper = A.length - 1;
        int[] res = new int[]{-1, -1};
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        
        while (lower <= upper) {
            int mid = (lower + upper) / 2;
            if (A[mid] < target) {
                lower = mid + 1;
            }
            else if (A[mid] > target) {
                upper = mid - 1;
            }
            else {
                min = mid;
                upper = mid - 1;
            }
        }
        if (min != Integer.MIN_VALUE) {
            res[0] = min;
        }
        else {
            return res;
        }
        
        upper = A.length - 1;
        while (lower <= upper) {
            int mid = (lower + upper) / 2;
            if (A[mid] > target) {
                upper = mid - 1;
            }
            else if (A[mid] < target) {
                lower = mid + 1;
            }
            else {
                max = mid;
                lower = mid + 1;
            }
        }
        res[1] = max;
        
        return res;
    }
}


//search lower and upper bound separately using binary search
