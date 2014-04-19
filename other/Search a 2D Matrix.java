public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int length = matrix[0].length;
        int width = matrix.length;
        int start = 0;
        int end = length * width - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int x = mid / length;
            int y = mid % length;
            if (matrix[x][y] == target) {
                return true;
            }
            else if (matrix[x][y] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
}

//binary search
