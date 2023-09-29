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
    ListNode *detectCycle(ListNode *head) {
        ListNode *slow = head;
        ListNode *fast = head;
        ListNode *temp = head;

        while(fast && fast->next)
        {
            slow = slow->next;
            fast = fast->next->next;
            if(fast == slow)    break;
        }
        if(fast == NULL || fast->next == NULL)  return NULL;

        while(temp!=slow)
        {
            temp = temp->next;
            slow = slow->next;
        }
        return slow;
    }
};