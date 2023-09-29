/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(k<=1 || head == NULL)    return head;
        int c = llength(head)/k;

        ListNode *prev = NULL;
        ListNode *cur = head;
        while(c > 0)
        {   
            ListNode *last = prev;
            ListNode *newend = cur;

            ListNode *nex = cur->next;
            for(int i=0;cur != NULL && i<k; i++)
            {
                cur->next = prev;
                prev = cur;
                cur = nex;
                if(nex != NULL)   nex = nex->next;
            }

            if(last != NULL)    last->next = prev;
            else    head = prev;

            newend->next = cur;
            prev = newend;

            c--;
        }
        return head;
    }
    int llength(ListNode *head)
    {
        ListNode *temp = head;
        int l = 0;
        while(temp != NULL)
        {
            l++;
            temp = temp->next;
        }
        return l;
    }
        
};