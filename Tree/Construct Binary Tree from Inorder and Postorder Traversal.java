public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int val = postorder[postEnd];
        TreeNode node = new TreeNode(val);
        int i = inEnd;
        while (inorder[i] != val) {
            i--;
        }
        
        node.left = helper(inorder, postorder, inStart, i - 1, postStart, postEnd - (inEnd - i) - 1);
        node.right = helper(inorder, postorder, i + 1, inEnd, postEnd - (inEnd - i), postEnd - 1);
        return node;
    }
}
