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
    public int[][] spiralMatrix(int n, int m, ListNode head) {
        int[][] arr = new int[n][m];

        for(int i=0;i<n;i++)
            Arrays.fill(arr[i], -1);

        ListNode temp = head;

        int dir = 0;
        int t = 0;
        int l = 0;
        int r = m-1;
        int b = n-1;

        while(temp != null && t<=b && l<=r)
        {
            if(dir == 0)
            {
                for(int i=l;i<=r;i++)
                {
                    if(temp != null)
                    {
                        arr[t][i] = temp.val;
                        temp = temp.next;
                    }
                }
                t++;
            }
            else if(dir == 1)
            {
                for(int i=t;i<=b;i++)
                {
                    if(temp != null)
                    {
                        arr[i][r] = temp.val;
                        temp = temp.next;
                    }
                }
                r--;
            }
            else if(dir == 2)
            {
                for(int i=r;i>=l;i--)
                {
                    if(temp != null)
                    {
                        arr[b][i] = temp.val;
                        temp = temp.next;
                    }
                }
                b--;
            }
            else
            {
                for(int i=b;i>=t;i--)
                {
                    if(temp != null)
                    {
                        arr[i][l] = temp.val;
                        temp = temp.next;
                    }
                }
                l++;
            }
            dir = (dir+1) % 4;
        }
        return arr;
    }
}