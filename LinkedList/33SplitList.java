class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while(temp != null)
        {
            n++;
            temp = temp.next;
        }        
        ListNode[] arr = new ListNode[k];

        int x = n/k;
        int initialnodes = n%k;
        
        temp = head;
        for(int i=1;i<=k;i++)
        {
            ListNode subhead = temp;
            int size = x + (i<=initialnodes ? 1 : 0);
            for(int j=1;j<size && temp != null;j++)
                temp = temp.next;
            if(temp != null)
            {
                ListNode prev = temp.next;
                temp.next = null;
                temp = prev;
            }
            arr[i-1] = subhead;
        }
        System.out.println(n);
        return arr;
    }
}