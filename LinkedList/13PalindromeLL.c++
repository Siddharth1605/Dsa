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
    ListNode *reverseList(ListNode *head)
    {
        ListNode *cur = head;
        ListNode *nex = cur;
        ListNode *prev = NULL;
        while(nex != NULL)
        {
            nex = nex->next;
            cur->next = prev;
            prev = cur;
            cur = nex;
        }
        return prev;
    }

    ListNode *getMid(ListNode *head)
    {
        ListNode *slow = head;
        ListNode *fast = head;
        while(fast && fast->next)
        {
            slow = slow->next;
            fast = fast->next->next;
        }
        return slow;
    }
    
    bool isPalindrome(ListNode* head) {
        ListNode *mid = getMid(head);
        ListNode *headsecond = reverseList(mid);
        ListNode *rev = headsecond;
        while(head && headsecond)
        {
            if(head->val != headsecond->val)    break;
            head = head->next;
            headsecond = headsecond->next;
        }
        reverseList(rev);
        return head == NULL || headsecond == NULL;
    }
};