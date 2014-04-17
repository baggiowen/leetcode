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
