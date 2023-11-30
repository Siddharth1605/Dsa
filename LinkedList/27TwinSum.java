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
    public static ListNode mid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = slow;
        while(fast != null && fast.next !=null)
        {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;
        return slow;
    }
    public static ListNode rev(ListNode head)
    {
        ListNode cur = head;
        ListNode prev = null;
        ListNode nex = head;
        while(nex != null)
        {
            nex = nex.next;
            cur.next = prev;
            prev = cur;
            cur = nex;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode middle = mid(head);
        ListNode sec = rev(middle);
        int ans = 0;
        while(head!=null || sec != null)
        {
            ans = Math.max(ans, head.val + sec.val);
            head = head.next;
            sec = sec.next;
        }   
        return ans;
    }
}