public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode cur = fake;
        while (cur.next != null) {
            ListNode next = cur.next;
            while (next.next != null && next.next.val == next.val) {
                next = next.next;
            }
            if (cur.next == next) {
                cur = next;
            }
            else {
                cur.next = next.next;
            }
        }
        return fake.next;
    }
}

//two pointers. 
