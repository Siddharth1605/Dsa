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
    public static ListNode rev(ListNode head)
    {
        ListNode nex = head;
        ListNode cur = head;
        ListNode prev = null;
        while(nex != null)
        {
            nex = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        ListNode revhead = rev(head);
        ListNode prev = revhead;
        ListNode temp = prev.next;
        int max = prev.val;
        while(temp != null)
        {
            if(temp.val >= max)
            {
                prev.next = temp;
                prev = prev.next;
                max = temp.val;
            }
            temp = temp.next;
        }
        prev.next = null;
         
        return rev(revhead);
    }
}