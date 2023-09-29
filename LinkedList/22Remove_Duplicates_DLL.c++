/**
 * Definition of doubly linked list:
 * class Node {
 * public:
 *      int data;
 *      Node *prev;
 *      Node *next;
 *      Node() {
 *          this->data = 0;
 *          this->prev = NULL;
 *          this->next = NULL;
 *      }
 *      Node(int data) {
 *          this->data = data;
 *          this->prev = NULL;
 *          this->next = NULL;
 *      }
 *      Node (int data, Node *next, Node *prev) {
 *          this->data = data;
 *          this->prev = prev;
 *          this->next = next;
 *      }
 * };
 *
 *************************************************************************/

Node * removeDuplicates(Node *head)
{
    // Write your code here
    if(head == NULL || head->next == NULL)  return head;
    Node *temp = head;
    while(temp->next)
    {
      if (temp->data == temp->next->data) {
        temp->next = temp->next->next;
        if(temp->next)
        temp->next->prev = temp;
      }
        
    else    temp = temp->next;
    }

    return head;
}
