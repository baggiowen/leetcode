============
recursively
============
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        getResult(root,result);
        return result;
    }
    
    public void getResult(TreeNode node, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        getResult(node.left, result);
        result.add(node.val);
        getResult(node.right, result);
    }
}


============
iteratively
============

public class Solution {
    ArrayList<Integer> result = new ArrayList<Integer>();
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (nodes.size() != 0 || node != null) {
            if (node !=  null) {
                nodes.add(node);
                node = node.left;
            }
            else {
                TreeNode temp = nodes.removeLast();
                res.add(temp.val);
                node = temp.right;
            }
        }
        return res;
    }
}
