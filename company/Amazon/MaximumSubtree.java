/**
Given a binary tree, find the subtree with maximum sum. Return the root of the subtree.

Example
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   3 -4  -5 
return the node with value 3.

*/

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the maximum weight node
     */
     
     int max = Integer.MIN_VALUE;
     TreeNode ret = null;
     
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        helper(root);
        return ret;
    }
    
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = helper(node.left);
        int right = helper(node.right);
        int sum = node.val + left + right;
        if (sum > max) {
            max = sum;
            ret = node;
        }
        return sum;
    }
}
