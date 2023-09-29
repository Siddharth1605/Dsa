/**
 * Definition of doubly linked list:
 *
 * struct Node {
 *      int data;
 *      Node *prev;
 *      Node *next;
 *      Node() : data(0), prev(nullptr), next(nullptr) {}
 *      Node(int val) : data(val), prev(nullptr), next(nullptr) {}
 *      Node(int val, Node *p, Node *n) : data(val), prev(p), next(n) {}
 * };
 *
 *************************************************************************/

Node * deleteLastNode(Node *head) {
    // Write your code here
    Node *temp = head;
    if(head->next == NULL)  return NULL;
    Node *pre;
    while(temp->next != NULL)
    {
        pre = temp;
        temp = temp->next;
    }
    pre->next = NULL;
    return head;
}
