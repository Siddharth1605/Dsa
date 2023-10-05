/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* fun(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        if(!root || root == p || root == q) return root;

        TreeNode *left = fun(root->left, p, q);
        TreeNode *right = fun(root->right, p, q);

        if(!left)   return right;
        else if(!right) return left;
        else    return root;
    }
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root)   return NULL;
        return fun(root, p, q);
    }
};
