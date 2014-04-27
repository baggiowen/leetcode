public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length <= 2) {
            return A.length;
        }
        int prev = 1;
        int cur = 2;
        while (cur < A.length) {
            if (A[prev] == A[cur] && A[prev - 1] == A[cur]) {
                cur++;
            }
            else {
                prev++;
                A[prev] = A[cur];
                cur++;
            }
        }
        return prev + 1;
    }
}

//two pointers
