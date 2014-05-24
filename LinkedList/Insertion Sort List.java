public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode node = head;
        ListNode fake = new ListNode(0);
        fake.next = head;
        while (node.next != null) {
            int val = node.next.val;
            ListNode temp = fake;
            while (val > temp.next.val) {
                temp = temp.next;
            }
            if (temp.next == node.next) {
                node = node.next;
                continue;
            }
            ListNode temp2 = temp.next;
            temp.next = node.next;
            node.next = node.next.next;
            temp.next.next = temp2;
        }
        return fake.next;
    }
}

//居然自己开动脑筋之后 一次就过
//跟array的insertion sort 不同（从当前结点向前交换），这个需要每次从头结点开始与当前结点比较 找到需要插入的位置 然后挪动结点 注意corner case
