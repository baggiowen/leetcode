public class Solution {
    public boolean canJump(int[] A) {
        if (A.length == 0) {
            return false;
        }
        if (A.length == 1) {
            return true;
        }
        if (A[0] == 0) {
            return false;
        }
        int[] B = new int[A.length];
        B[0] = A[0];
        for (int i = 1; i < A.length - 1; i++) {
            B[i] = Math.max(B[i-1] - 1, A[i]);
            if (B[i] == 0) {
                return false;
            }
        }
        return true;
    }
}

//be careful with corner cases
//use an extra array to keep track of how many steps left. return false when it's 0
//other solutions: http://fisherlei.blogspot.com/2012/12/leetcode-jump-game.html
