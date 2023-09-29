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

Node* createTree(vector<int>&arr){
    // Write your code here.
    if(arr.empty()) return nullptr;
    Node *root = new Node(arr[0]);

    queue<Node *> q;
    q.push(root);
    int n = arr.size();
    for(int i=1;i<n;i+=2)
    {
        Node *cur = q.front();
        q.pop();

        if(i<n && arr[i]!=-1)
        {
            cur->left = new Node(arr[i]);
            q.push(cur->left);
        }
        if(i+1<n && arr[i+1]!=-1)
        {
            cur->right = new Node(arr[i+1]);
            q.push(cur->right);
        }
    }
    return root;
}