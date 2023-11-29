
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        ListNode end = head;
        for(int i=1;i<k;i++)
            end = end.next;
        right = end;
        while(end.next != null)
        {
            end = end.next;
            left = left.next;
        }
        int t = left.val;
        left.val = right.val;
        right.val = t;

        return head;
    }
}