/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void preorder(TreeNode *root, vector<int> &prelist)
    {
        if(!root)   return;
        prelist.push_back(root->val);
        preorder(root->left, prelist);
        preorder(root->right, prelist);
    }
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> prelist;
        preorder(root, prelist);
        return prelist;
    }
};