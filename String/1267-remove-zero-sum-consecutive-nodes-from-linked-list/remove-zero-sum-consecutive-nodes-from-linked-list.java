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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        Map<Integer, ListNode> mp = new HashMap<>();
        mp.put(0, dummy);
        dummy.next = head;
        int prefixsum = 0;
        while(head != null)
        {
            prefixsum += head.val;
            if(mp.containsKey(prefixsum))
            {
                int sum = prefixsum;
                ListNode start = mp.get(prefixsum);
                ListNode temp = start;
                while(temp != head)
                {
                    temp = temp.next;
                    sum += temp.val;
                    if(temp != head)
                        mp.remove(sum);
                }
                start.next = head.next;
            }
            else
                mp.put(prefixsum, head);
            head = head.next;
        }
        return dummy.next;
    }
}