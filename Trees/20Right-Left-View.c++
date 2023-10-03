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
    void rightView(TreeNode *root, int level, vector<int> &ds)
    {
        if(!root)   return;

        if(level == ds.size())  ds.push_back(root->val);
        
        rightView(root->right, level + 1, ds);
        rightView(root->left, level + 1, ds);
    }
    vector<int> rightSideView(TreeNode* root) {
        vector<int> ds;
        rightView(root, 0, ds);
        return ds;
    }
};