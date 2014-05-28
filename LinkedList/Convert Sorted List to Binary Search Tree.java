//基本思路也就是吧list拆分成前后两节 和array差不多
//while的condition是关键
//不要忘了把相应节点的next值设为null

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null && fast.next.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode node = new TreeNode(slow.next.val);
        ListNode second = null;
        if (slow.next != null && slow.next.next != null) {
            second = slow.next.next;
        }
        slow.next.next = null;
        slow.next = null;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(second);
        return node;
    }
}
