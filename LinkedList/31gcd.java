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
    public static int gcd(int a, int b) {
        if (b == 0) 
            return a;
        return gcd(b, a % b);
     }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null)    return head;
        ListNode temp = head;
        while(temp.next != null)
        {
            ListNode cur = temp;
            ListNode nex = temp.next;
            int x = gcd(cur.val, nex.val);
            ListNode newnode = new ListNode(x);
            newnode.next = nex;
            cur.next = newnode;
            temp = nex;
        }
        return head;
    }
}