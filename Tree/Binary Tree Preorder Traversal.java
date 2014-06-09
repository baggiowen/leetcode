public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || stack.size() != 0) {
            if (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                node = node.right;
            }
        }
        return res;
    }
}
