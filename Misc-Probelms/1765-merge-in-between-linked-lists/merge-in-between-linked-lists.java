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
        ListNode first = null;
        ListNode last = null;
        int i = 0;
        ListNode temp = list1;
        while(temp != null)
        {
            if(i==a-1)
            {
                first = temp;
            }
            if(i==b+1)
            {
                last = temp;
            }
            temp = temp.next;
            i++;
        }
        first.next = list2;
        temp = list2;
        while(temp.next != null)
            temp = temp.next;
        if(temp != null)
        System.out.println(temp.val);
        if(last != null)
        System.out.println(last.val);
        temp.next = last;
        return list1;
    }
}