http://blog.csdn.net/perfect8886/article/details/20000083

http://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/

public class Solution {
    TreeNode lastVisit = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode right = root.right;
        if (lastVisit != null) {
            lastVisit.left = null;
            lastVisit.right = root;
        }
        lastVisit = root;
        flatten(root.left);
        flatten(right);
    }
}
