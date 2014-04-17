public class Solution {
    public int search(int[] A, int target) {
        return binarySearch(A, target, 0, A.length - 1);
    }
    
    public int binarySearch(int[] A, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (A[mid] == target) {
            return mid;
        }
        if (A[start] <= A[mid]) {
            if (A[start] <= target && target < A[mid]) {
                return binarySearch(A, target, start, mid - 1);
            }
            else {
                return binarySearch(A, target, mid + 1, end);
            }
        }
        else {
            if (A[mid] < target && target <= A[end]) {
                return binarySearch(A, target, mid + 1, end);
            }
            else {
                return binarySearch(A, target, start, mid - 1);
            }
        }
    }
}

//binary search
//two cases: left side is sorted or right side is sorted
