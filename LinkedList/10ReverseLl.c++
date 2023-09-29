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
    ListNode* reverseList(ListNode* head) {
        if(head == NULL || head->next == NULL)  return head;
        ListNode *cur = head;
        ListNode *nex = head;
        ListNode *pre = NULL;
        while(nex != NULL)
        {
            nex = nex->next;
            cur->next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
     }
};