/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if(headA == NULL || headB == NULL )
            return NULL;
        ListNode *h1 = headA;
        ListNode *h2 = headB;
        int l1 = 0;
        int l2 = 0;
        while(h1)
        {
            h1 = h1->next;
            l1++;
        }
        while(h2)
        {
            h2 = h2->next;
            l2++;
        }
        h1 = headA;
        h2 = headB;

        int l = l2 - l1;
        if(l>=0)
        for(int i=0;i<l;i++)    h2 = h2->next;
        else
        {
            l = -l;
            for(int i=0;i<l;i++)    h1 = h1->next;
        }

        while(h1 && h2)
        {
            if(h1 == h2)    return h2;
            h1 = h1->next;
            h2 = h2->next;
        }
            return NULL;
    }
};