============================
first attempt - not elegant
============================
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0 || A.length == 1) {
            return A.length;
        }
        int length = A.length;
        int base = A[0];
        int index = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] == base) {
                A[i] = 0;
                length--;
            }
            else {
                A[++index] = A[i];
                base = A[i];
            }
        }
        return length;
    }
}

=============================
second attempt - better
=============================
public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }
        int index = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[index]) {
                A[++index] = A[i];
            }
        }
        return index + 1;
    }
}
