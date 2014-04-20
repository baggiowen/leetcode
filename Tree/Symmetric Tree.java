public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);
    }
    
    public boolean isSym(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 == null) {
            return false;
        }
        if (node1 == null && node2 != null) {
            return false;
        }
        return node1.val == node2.val && isSym(node1.left, node2.right) && isSym(node1.right, node2.left);
    }
}
