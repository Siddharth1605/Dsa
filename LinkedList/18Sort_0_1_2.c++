/*
Following is the class structure of the Node class:

class Node
{
public:
    int data;
    Node *next;
    Node()
    {
        this->data = 0;
        next = NULL;
    }
    Node(int data)
    {
        this->data = data; 
        this->next = NULL;
    }
    Node(int data, Node* next)
    {
        this->data = data;
        this->next = next;
    }
};
*/

Node* sortList(Node *head){
    // Write your code here
    
    if(head == NULL || head->next == NULL)  return head;
    Node *zerohead = new Node(0);
    Node *onehead = new Node(0);
    Node *twohead = new Node(0);

    Node *zero = zerohead;
    Node *one = onehead;
    Node *two = twohead;

    Node *current = head;
    while(current)
    {
        if(current->data == 0)
        {
            zero->next = current;
            zero = zero->next;
        }
        else if(current->data == 1)
        {
            one->next = current;
            one = one->next;
        }
        else
        {
            two->next = current;
            two = two->next;
        }
        current = current->next;
    }

    zero->next = onehead->next ? onehead->next : twohead->next;
    one->next = twohead->next;
    two->next = NULL;

    head = zerohead->next;

    return head;
}