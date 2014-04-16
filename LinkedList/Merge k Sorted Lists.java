public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        Comparator<ListNode> comparator = new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        };
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), comparator);
        for (ListNode node : lists) {
            if (node != null) { //don't forget the case that ListNode could be empty
                pq.add(node);
            }
        }
        ListNode fake = new ListNode(0);
        ListNode node = fake;
        while (pq.size() != 0) {
            ListNode cur = pq.poll(); //priorityqueue operation
            if (cur.next != null) {
                pq.add(cur.next);
            }
            node.next = cur;
            node = node.next;
        } 
        return fake.next;
    }
}

//use a priority queue to solve the problem
//priority queue constructor
//how to create a comparator
