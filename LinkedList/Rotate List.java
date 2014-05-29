//把最后一个节点和第一个节点连起来成为设一个环 找到指定的定后再断开

public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) {
            return head;
        }
        ListNode node = head;
        int len = 1;
        while (node.next != null) {
            node = node.next;
            len++;
        }
        node.next = head;
        node = head;
        int count = 1;
        while (count < len - n % len) {
            node = node.next;
            count++;
        }
        head = node.next;
        node.next = null;
        return head;
    }
}
