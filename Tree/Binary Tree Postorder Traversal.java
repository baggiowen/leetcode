public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode lastVisited = null;
        while (node != null || stack.size() != 0) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.peek();
                if (node.right != null && lastVisited != node.right) {
                    node = node.right;
                }
                else {
                    res.add(stack.pop().val);
                    lastVisited = node;
                    node = null;
                }
            }
        }
        return res;
    }
}

//keep track of last visited node
