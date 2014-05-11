************************************
A naive method to solve this problem is to search all positive integers, starting from 1 in the given array. We may have to search at most n+1 numbers in the given array. So this solution takes O(n^2) in worst case.

We can use sorting to solve it in lesser time complexity. We can sort the array in O(nLogn) time. Once the array is sorted, then all we need to do is a linear scan of the array. So this approach takes O(nLogn + n) time which is O(nLogn).

We can also use hashing. We can build a hash table of all positive elements in the given array. Once the hash table is built. We can look in the hash table for all positive integers, starting from 1. As soon as we find a number which is not there in hash table, we return it. This approach may take O(n) time on average, but it requires O(n) extra space.
*************************************
http://leetcodenotes.wordpress.com/2013/07/17/first-missing-positive/

public class Solution {
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1]) { //注意判断条件
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
                i--; //这步很关键
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}
