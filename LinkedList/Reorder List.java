http://www.programcreek.com/2013/12/in-place-reorder-a-singly-linked-list-in-java/

public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = head;
        ListNode right = slow.next;
	    slow.next = null;
        right = reverse(right);
        merge(left, right);
    }
    
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }
    
    public void merge(ListNode left, ListNode right) {
        while (right != null) {
            ListNode n1 = left.next;
            ListNode n2 = right.next;
            
            left.next = right;
            right.next = n1;
            
            left = n1;
            right = n2;
        }
    }
}

//find the middle node, reverse second part, merge
//don't forget to set the last node'next in the first part to null
