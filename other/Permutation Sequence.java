http://fisherlei.blogspot.com/2013/04/leetcode-permutation-sequence-solution.html

public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> num = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            num.add(i);
        }
        
        k--;
        
        int mod = 1;
        for (int i = 1; i <= n; i++) {
            mod *= i;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            mod = mod / (n - i);
            int curIndex = k / mod;
            k = k % mod;
            
            sb.append(num.get(curIndex));
            num.remove(curIndex);
        }
        
        return sb.toString();
    }
}
