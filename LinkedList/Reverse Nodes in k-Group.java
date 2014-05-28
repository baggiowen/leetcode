http://www.cnblogs.com/lichen782/p/leetcode_Reverse_Nodes_in_kGroup.html

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;
        int count = 0;
        while (head != null) {
            count++;
            if (count % k == 0) {
                prev = reverseRange(prev, head.next);
                head = prev.next;
            }
            else {
                head = head.next;
            }
        }
        return fake.next;
    }
    
    public ListNode reverseRange(ListNode prev, ListNode post) {
        ListNode last = prev.next;
        ListNode cur = last.next;
        while (cur != post) {
            ListNode next = cur.next;
            cur.next = last;
            last = cur;
            cur = next;
        }
        prev.next.next = post;
        ListNode temp = prev.next;
        prev.next = last;
        return temp;
    }
}
