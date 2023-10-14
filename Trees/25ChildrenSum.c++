/*
Following is the class structure of the Node class:

class Node
{
public:
    int data;
    Node *left, *right;
    Node()
    {
        this->data = 0;
        left = NULL;
    }
    Node(int data)
    {
        this->data = data; 
        this->left = NULL;
        this->right = NULL;
    }
    Node(int data, Node* left, Node* right)
    {
        this->data = data;
        this->left = left;
        this->right = right;
    }
};
*/

bool fun(Node *root)
{
    if(!root)   return true;
    int s = 0;
    if(root->left) s += root->left->data;
    if(root->right) s+=root->right->data;
    if(!root->left && !root->right) s=root->data;
    return (root->data == s) && fun(root->left) && fun(root->right);
}
bool isParentSum(Node *root){
    // Write your code here.
    return fun(root);
}