public class Solution {
    public boolean search(int[] A, int target) {
        return binarySearch(A, target, 0, A.length - 1);
    }
    
    public boolean binarySearch(int[] A, int target, int start, int end) {
        if (start > end) {
            return false;
        }
        int mid = (start + end) / 2;
        if (A[mid] == target) {
            return true;
        }
        if (A[start] < A[mid]) {
            if (A[start] <= target && target < A[mid]) {
                return binarySearch(A, target, start, mid - 1);
            }
            else {
                return binarySearch(A, target, mid + 1, end);
            }
        }
        else if (A[mid] < A[end]) {
            if (A[mid] < target && target <= A[end]) {
                return binarySearch(A, target, mid + 1, end);
            }
            else {
                return binarySearch(A, target, start, mid - 1);
            }
        }
        else {
            if (A[start] == A[mid] && A[mid] != A[end]) {
                return binarySearch(A, target, mid + 1, end);
            }
            else if (A[end] == A[mid] && A[mid] != A[start]) {
                return binarySearch(A, target, start, mid - 1);
            }
            else {
                return binarySearch(A, target, start, mid - 1) || binarySearch(A, target, mid + 1, end);
            }
        }
    }
}

//consider the case where A[start] == A[mid] && A[mid] == A[end]
