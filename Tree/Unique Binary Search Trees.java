http://fisherlei.blogspot.com/2013/03/leetcode-unique-binary-search-trees.html
http://jane4532.blogspot.com/2013/07/unique-binary-search-tree.html
//关键点：当数组为 1，2，3，4，.. i，.. n时，基于以下原则的BST建树具有唯一性：
//以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成

public class Solution {
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int left = numTrees(i - 1);
            int right = numTrees(n - i);
            if (left == 0) {
                res += right;
            }
            else if (right == 0) {
                res += left;
            }
            else if (left != 0 && right != 0) {
                res += left * right;
            }
        }
        return res;
    }
}
