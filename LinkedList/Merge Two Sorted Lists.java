public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(0);
        ListNode node = fake;
        while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    node.next = l1;
                    node = node.next;
                    l1 = l1.next;
                }
                else {
                    node.next = l2;
                    node = node.next;
                    l2 = l2.next;
                }
            }
            if (l1 != null) {
                node.next = l1;
            }
            else {
                node.next = l2;
            }
        return fake.next;
    }
}
