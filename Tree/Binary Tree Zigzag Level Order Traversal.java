public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        int i = 0;
        List<TreeNode> pre = new LinkedList<TreeNode>();
        pre.add(root);
        while (pre.size() != 0) {
            List<TreeNode> cur = new LinkedList<TreeNode>();
            List<Integer> nums = new ArrayList<Integer>();
            for (TreeNode node : pre) {
                nums.add(node.val);
                if (node.left != null) {
                    cur.add(node.left);
                }
                if (node.right != null) {
                    cur.add(node.right);
                }
            }
            if (i % 2 == 1) {
                List<Integer> temp = new ArrayList<Integer>();
                for (int j = nums.size() - 1; j >= 0; j--) {
                    temp.add(nums.get(j));
                }
                res.add(temp);
            }
            else {
                res.add(nums);
            }
            pre = cur;
            i++;
        }
        return res;
    }
}
