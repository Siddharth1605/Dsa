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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        int l = length(head);
        if(n == 1)  return delLast(head);
        else if(n == l) return delBeg(head);
        else return delPos(head, l-n);
    }
    int length(ListNode *head)
    {
        if(head == NULL)    return 0;
        int l = 1;
        while(head->next != NULL)   {head = head->next; l++;}
        return l;
    }
    ListNode* delBeg(ListNode *head)
    {
        if(head == NULL)    return head;
        head = head->next;
        return head;
    }
    ListNode *delPos(ListNode *head, int n)
    {
        int p = 1;
        ListNode *temp = head;
        while(p<n)
        {
            temp = temp->next;
            p++;
        }
        temp->next = temp->next->next;
                return head;

    }
    ListNode* delLast(ListNode *head)
    {
        if(head == NULL || head->next == NULL)  return NULL;
        ListNode *temp = head;
        ListNode *prev = NULL;
        while(temp->next != NULL)
        {
            prev = temp;
            temp = temp->next;
        }
        prev->next = NULL;
        return head;
    }
};