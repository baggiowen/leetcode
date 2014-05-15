public class Solution {
    public int jump(int[] A) {
        if (A.length <= 1) {
            return 0;
        }
        int step = 0;
        int i = 0;
        while (i < A.length) {
            int next = i + A[i];
            int farest = i + A[i];
            for (int j = i + 1; j <= i + A[i]; j++) {
                if (j == A.length - 1) {
                    return ++step;
                }
                if (j + A[j] > farest) {
                    farest = j + A[j];
                    next = j;
                }
            }
            i = next;
            step++;
        }
        return 0;
    }
}

//依旧贪心去推，贪心的规则就是在能够到达的范围之内，选择一个能够到达最远距离的点，更新步数，和更新最远到达的范围。
