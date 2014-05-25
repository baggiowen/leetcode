//merge sort
//把list分成两部分的时候 不要忘了把第一部分的最后一个节点的next设为null

public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode slow = fake;
        ListNode fast = fake;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode n1 = sortList(head);
        ListNode n2 = sortList(right);
        ListNode newHead = merge(n1, n2);
        return newHead;
    }
    
    public ListNode merge(ListNode n1, ListNode n2) {
        ListNode fake = new ListNode(0);
        ListNode node = fake;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                node.next = n1;
                n1 = n1.next;
            }
            else {
                node.next = n2;
                n2 = n2.next;
            }
            node = node.next;
        }
        if (n1 == null) {
            node.next = n2;
        }
        else {
            node.next = n1;
        }
        return fake.next;
    }
}
