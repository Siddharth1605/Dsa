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
    public ListNode mergeNodes(ListNode head) {
        ListNode prev = head;
        ListNode temp = head.next;
        int sum = 0;
        while(temp != null)
        {
            sum += temp.val;
            if(temp.val == 0)
            {
                prev.val = sum;
                prev.next = temp;
                if(temp.next != null)
                    prev = temp;
                sum = 0;
            }
            temp = temp.next;
        }
        prev.next = null;
        return head;
    }
}