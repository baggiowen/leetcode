=========================================
first attempt - accepted, but not elegant
=========================================
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 ==null) {
            return null;
        }
        int extra = 0;
        int val = 0;
        ListNode node = new ListNode(-1);
        ListNode head = node;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                val = l1.val + l2.val + extra;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if (l1 == null) {
                val = l2.val + extra;
                l2 = l2.next;
            }
            else if (l2 == null) {
                val = l1.val + extra;
                l1 = l1.next;
            }
            if (val > 9) {
                val = val % 10;
                extra = 1;
            }
            else {
                extra = 0;
            }
            ListNode newNode = new ListNode(val);
            node.next = newNode;
            node = newNode;
        }
        if (extra == 1) {
            ListNode newNode = new ListNode(1);
            node.next = newNode;
        }
        return head.next;
    }
}

==============================================
second attempt - more elegant
==============================================
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode fake = new ListNode(0);
        ListNode node = fake;
        int extra = 0;
        while (l1 != null || l2 != null || extra != 0) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int result = num1 + num2 + extra;
            int temp = result % 10;
            extra = result / 10;
            ListNode newNode = new ListNode(temp);
            node.next = newNode;
            node= newNode;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return fake.next;

    }
}

//use a fake node
//the while condition is the key to be elegant
