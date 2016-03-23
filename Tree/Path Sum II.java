public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        List<Integer> vals = new ArrayList<Integer>();
        helper(root, sum, vals, ret);
        return ret;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> vals, List<List<Integer>> ret) {
        vals.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            ret.add(new ArrayList(vals));
        }
        if (root.left != null) {
            helper(root.left, sum - root.val, vals, ret);
        }
        if (root.right != null) {
            helper(root.right, sum - root.val, vals, ret);
        }
        vals.remove(vals.size() - 1);
    }
}
