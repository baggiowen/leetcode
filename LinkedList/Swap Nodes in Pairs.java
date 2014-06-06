public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode n1 = fake;
        ListNode n2 = head;
        
        while(n2!=null && n2.next!=null){
            ListNode temp = n2.next.next;
            n2.next.next = n1.next;
            n1.next = n2.next;
            n2.next = temp;
            n1 = n2;
            n2 = n1.next;
        }
        
        return fake.next;
    }
}

//特别绕。。。calm down...step by step...
//用实际例子来帮助解题 列出所有需要改变的结点 然后根据他们要被改变的值决定先后顺序

//2014.6.5 update - 再写一遍已经熟练多了
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode temp = cur.next.next;
            cur.next.next = pre.next;
            pre.next = cur.next;
            cur.next = temp;
            pre = cur;
            cur = pre.next;
        }
        return fake.next;
    }
}
