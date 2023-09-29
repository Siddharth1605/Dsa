/*
    Following is Binary Tree Node structure:
    class TreeNode
    {
    public:
        int data;
        TreeNode *left, *right;
        TreeNode() : data(0), left(NULL), right(NULL) {}
        TreeNode(int x) : data(x), left(NULL), right(NULL) {}
        TreeNode(int x, TreeNode *left, TreeNode *right) : data(x), left(left), right(right) {}
    };
*/
void preorder(TreeNode *root, vector<int> &preorderList)
{
    if(!root)   return;
    preorderList.push_back(root->data);
    preorder(root->left, preorderList);
    preorder(root->right, preorderList);
}
void inorder(TreeNode *root, vector<int> &inorderList)
{
    if(!root)   return;
    inorder(root->left, inorderList);
    inorderList.push_back(root->data);
    inorder(root->right, inorderList);
}
void postorder(TreeNode *root, vector<int> &postorderList)
{
    if(!root)   return;
    postorder(root->left, postorderList);
    postorder(root->right, postorderList);
    postorderList.push_back(root->data);
}
vector<vector<int>> getTreeTraversal(TreeNode *root){
    // Write your code here.
    vector<int> postorderList;
    vector<int> inorderList;
    vector<int> preorderList;

    vector<vector<int>> ans;
    
    inorder(root, inorderList);
    preorder(root, preorderList);
    postorder(root, postorderList);

    ans.push_back(inorderList);
    ans.push_back(preorderList);
    ans.push_back(postorderList);

    return ans;
}