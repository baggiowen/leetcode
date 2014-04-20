public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        nodes.add(root);
        while (nodes.size () != 0) {
            LinkedList<TreeNode> next = new LinkedList<TreeNode>();
            ArrayList<Integer> num = new ArrayList<Integer>();
            for (TreeNode node : nodes) {
                num.add(node.val);
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
            res.add(num);
            nodes = next;
        }
        return res;
    }
}
