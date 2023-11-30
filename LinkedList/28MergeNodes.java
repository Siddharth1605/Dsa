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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int i = 0;
        ListNode prev = list1;
        ListNode temp = list1;

        while(i<a)
        {
            prev = temp;
            temp = temp.next;
            i++;
        }

        while(i<=b)
        {
            temp = temp.next;
            i++;
        }
        
        ListNode l = list2;
        prev.next = l;

        while(l.next!=null)
            l = l.next;
 
        l.next = temp;

        return list1;
    }
}