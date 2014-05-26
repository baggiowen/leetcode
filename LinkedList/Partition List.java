public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstFake = new ListNode(0);
        ListNode secondFake = new ListNode(0);
        ListNode first = firstFake;
        ListNode second = secondFake;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            if (node.val < x) {
                first.next = node;
                first = first.next;
            }
            else {
                second.next = node;
                second = second.next;
            }
            node = next;
        }
        first.next = secondFake.next;
        return firstFake.next;
    }
}

//设两个list
//用fakenode
//再遍历原list的时候不用忘了把其next设为null
