http://fisherlei.blogspot.com/2012/12/leetcode-populating-next-right-pointers_29.html

public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode temp = root.next;
        TreeLinkNode nextTarget = null;
        while (temp != null) {
            if (temp.left != null) {
                nextTarget = temp.left;
                break;
            }
            else if (temp.right != null) {
                nextTarget = temp.right;
                break;
            }
            temp = temp.next;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            }
            else {
                root.left.next = nextTarget;
            }
        }
        if (root.right != null) {
            root.right.next = nextTarget;
        }
        connect(root.right);
        connect(root.left);
    }
}

//类似于Populating Next Right Pointers in Each Node I, 两点变化
//1. 要找出下一个有children的next结点
//2. 遍历时先右子树后左子树
