/*
 * Definition for doubly-linked list.
 * class Node
 * {
 * public:
 *    int data;
 *    Node *next, *prev;
 *    Node() : data(0), next(nullptr), prev(nullptr) {}
 *    Node(int x) : data(x), next(nullptr), prev(nullptr) {}
 *    Node(int x, Node *next, Node *prev) : data(x), next(next), prev(prev) {}
 * };
 */
Node *head,*last;
void createel(int x)
{
    Node *newnode = new Node(x);
    if(head == NULL)
        head = newnode;
    else{
        last->next = newnode;
        newnode->prev = last;
    }
    last = newnode;
}
Node* constructDLL(vector<int>& arr) {
    // Write your code here
    for(int i=0;i<arr.size();i++)   createel(arr[i]);
    return head;
}
