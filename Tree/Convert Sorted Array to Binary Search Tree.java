public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        return convert(num, 0, num.length - 1);
    }
    
    public TreeNode convert(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = convert(num, start, mid - 1);
        node.right = convert(num, mid + 1, end);
        return node;
    }
}
