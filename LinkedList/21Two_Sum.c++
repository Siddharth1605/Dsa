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
 *          this -> data = data;
 *          this -> prev = prev;
 *          this -> next = next;
 *      }
 * };
 *
 *************************************************************************/

vector<pair<int, int>> findPairs(Node* head, int k)
{
    // Write your code here.
    vector<pair<int, int>> ans;
    if(head == NULL || head->next == NULL)  return ans;

    Node *left = head;
    Node *right = left;    

    while(right->next != NULL)   right = right->next;

    while(left != right && right->next != left)
    {
        int sum = left->data + right->data;
        if(sum == k){
          pair<int, int>p = {left->data, right->data};
          ans.push_back(p);
          left = left->next;
          right = right->prev;
        } else if (sum < k)
          left = left->next;
        else if(sum > k)   right = right->prev;

    }
    return ans;

}
