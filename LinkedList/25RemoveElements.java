 
class Solution {
    public ListNode removeElements(ListNode head, int x) {
        ListNode temp = head;
        ListNode prev = null;
        boolean flag = false;
        while(temp != null)
        {
            if(temp.val == x)
            {
                if(head == temp)
                    head = head.next;
                else
                    prev.next = temp.next;
                
            }
            else
                prev = temp;
            temp = temp.next;
        }
        return head;
    }
}