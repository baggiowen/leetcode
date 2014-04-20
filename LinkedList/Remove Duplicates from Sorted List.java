public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode comp = head;
        ListNode node = head.next;
        while (node != null) {
            if (node.val != comp.val) {
                comp.next = node;
                comp = node;
                node = node.next;
            }
            else {
                node = node.next;
            }
        }
        if (comp.next != null) {
            comp.next = null;
        }
        return head;
    }
}

