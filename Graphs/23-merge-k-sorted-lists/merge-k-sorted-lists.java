/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                    (a, b) -> a.val - b.val
                );        
        for(ListNode it : lists) 
            if(it != null)
                pq.add(it);
        while(!pq.isEmpty()) {
            ListNode minimum = pq.remove();
            if(minimum.next != null)
                pq.add(minimum.next);
            temp.next = minimum;
            temp = temp.next;
        }
        return dummy.next;

    }
}