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
    bool fun(TreeNode *rright, TreeNode *rleft)
    {
        if(!rright || !rleft)   return rright == rleft;
        return (rright->val == rleft->val) && fun(rright->right, rleft->left) && fun(rright->left, rleft->right);
    }
    bool isSymmetric(TreeNode* root) {
        return fun(root->right, root->left);
    }
};