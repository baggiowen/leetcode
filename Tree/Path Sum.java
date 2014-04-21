public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> nums = new LinkedList<Integer>();
        nodes.add(root);
        nums.add(root.val);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            int num = nums.remove();
            if (node.left == null && node.right == null & num == sum) {
                return true;
            }
            if (node.left != null) {
                nodes.add(node.left);
                nums.add(num + node.left.val);
            }
            if (node.right != null) {
                nodes.add(node.right);
                nums.add(num + node.right.val);
            }
            
        }
        return false;
    }
}

//use a stack to BFS
//one for node, one for sum
