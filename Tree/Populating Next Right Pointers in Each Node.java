http://fisherlei.blogspot.com/2012/12/leetcode-populating-next-right-pointers.html

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            if (root.next != null) {
                root.right.next = root.next.left;  //这步是关键
            }
            else {
                root.right.next = null;
            }
        }
        connect(root.left);
        connect(root.right);
    }
}
