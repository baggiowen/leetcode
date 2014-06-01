//http://leetcode.com/2011/04/construct-binary-tree-from-inorder-and-preorder-postorder-traversal.html
//recursive的坐标更新花了一些时间

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int val = preorder[preStart];
        TreeNode node = new TreeNode(val);
        int i = inStart;
        while (inorder[i] != val) {
            i++;
        }
        node.left = helper(preorder, inorder, preStart + 1, i - inStart + preStart, inStart, i - 1);
        node.right = helper(preorder, inorder, i - inStart + preStart + 1, preEnd, i + 1, inEnd);
        
        return node;
    }
}

