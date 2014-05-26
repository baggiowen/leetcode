//改了好多次 

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        int step = n - m;
        if (head.next == null || step == 0) {
            return head;
        }
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode prev = fake;
        while (m > 1) {
            prev = prev.next;
            m--;
        }
        ListNode cur = prev.next;
        ListNode post = cur.next;
        while (step > 0) {
            ListNode temp = post.next;
            post.next = cur;
            cur = post;
            post = temp;
            step--;
        }
        prev.next.next = post;  //一开始就错在这步 一开始设的值是cur.next 变成一个循环了
        prev.next = cur;
        return fake.next;
    }
}
