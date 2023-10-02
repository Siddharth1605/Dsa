/************************************************************

    Following is the Binary Tree node structure:

    template <typename T>
    class TreeNode
    {
    public:
        T data;
        TreeNode<T> *left;
        TreeNode<T> *right;

        TreeNode(T data)
        {
            this -> data = data;
            left = NULL;
            right = NULL;
        }

        ~TreeNode()
        {
            if(left)
                delete left;
            if(right)
                delete right;
        }
    };

************************************************************/
bool isLeaf(TreeNode<int> *root)
{
    return (root->left == NULL) && (root->right == NULL);
}
void addLeftBoundary(TreeNode<int> *root, vector<int> &ans)
{
    TreeNode<int> *cur = root->left;
    while(cur)
    {
        if(!isLeaf(cur))    ans.push_back(cur->data);
        if(cur->left) cur = cur->left;
        else cur = cur->right;
    }
}
void addLeaves(TreeNode<int> *root, vector<int> &ans)
{
    if(isLeaf(root))
    {
        ans.push_back(root->data);
        return;
    }
    if(root->left) addLeaves(root->left, ans);
    if(root->right) addLeaves(root->right, ans);
}
void addRightBoundary(TreeNode<int> *root, vector<int> &ans)
{
    TreeNode<int> *cur = root->right;
    vector<int> temp;
    while(cur)
    {
        if(!isLeaf(cur))    temp.push_back(cur->data);
        if(cur->right) cur = cur->right;
        else cur = cur->left;
    }
    for(int i=temp.size() - 1;i>=0;i--)
    {
        ans.push_back(temp[i]);
    }
}
void addBoundary(TreeNode<int> *root, vector<int> &ans)
{
    if(!isLeaf(root))   ans.push_back(root->data);
    addLeftBoundary(root, ans);

    addLeaves(root, ans);

    addRightBoundary(root, ans);
    
}

vector<int> traverseBoundary(TreeNode<int> *root)
{
	// Write your code here.
    vector<int> ans;
    if(!root)   return ans;
    addBoundary(root, ans);
    return ans;
}
