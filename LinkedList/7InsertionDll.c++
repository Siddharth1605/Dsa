/**
 * Definition of doubly linked list:
 *
 * struct Node {
 *      int value;
 *      Node *prev;
 *      Node *next;
 *      Node() : value(0), prev(nullptr), next(nullptr) {}
 *      Node(int val) : value(val), prev(nullptr), next(nullptr) {}
 *      Node(int val, Node *p, Node *n) : value(val), prev(p), next(n) {}
 * };
 *
 *************************************************************************/

Node *insertAtTail(Node *head, int k) {
  // Write your code here
    Node *temp = head;
    Node *newnode = new Node(k);
    if(head == NULL)
    {head = newnode;    return head;}
    while(temp->next != NULL)   temp=temp->next;
    temp->next = newnode;
    newnode->prev = temp;
    return head;
}
