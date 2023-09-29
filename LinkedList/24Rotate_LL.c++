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
    ListNode* rotateRight(ListNode* head, int k) {
        if(head==NULL || head->next == NULL)    return head;

        int l = length(head);
        k%=l;
        k = l-k;
        cout << l << " " << k;
        ListNode *tail = head;
        while(tail->next)   tail = tail->next;
        if(k>=1) tail->next = head;
        
        ListNode *temp  =head;
        for(int i=0;i<k-1;i++)    temp = temp->next;

        head = temp->next;
        temp->next = NULL;

        return head;
    }
    int length(ListNode *head)
    {
        int l = 0;
        while(head) {head = head->next; l++;}
        return l;
    }
};