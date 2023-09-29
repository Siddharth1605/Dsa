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
    ListNode* sortList(ListNode* head) 
    {
        if(head == NULL || head->next == NULL)  return head;
        ListNode *temp = NULL;
        ListNode *fast = head;
        ListNode *slow = head;
        while(fast && fast->next)
        {
            temp = slow;
            fast = fast->next->next;
            slow = slow->next;
        }

        temp->next = NULL;

        ListNode *l = sortList(head);   //Recursive left call
        ListNode *r = sortList(slow);   //Recursive right call

        return merge(l, r);
    }
    ListNode *merge(ListNode *l, ListNode *r)
    {
        ListNode *ans = new ListNode();
        ListNode *t = ans;
        while(l!=NULL && r!=NULL)
        {
            if(l->val <= r->val)
            {
                t->next = l;
                l = l->next;
            }
            else
            {
                t->next = r;
                r = r->next;
            }
            t = t->next;
        }

        if(l!=NULL) t->next = l; 
        if(r!=NULL) t->next = r;

        return ans->next;
    }


};