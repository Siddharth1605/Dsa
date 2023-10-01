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
    int depth(TreeNode *node)
    {
        if(!node)   return 0;
        int l = depth(node->left);
        int r = depth(node->right);
        return 1 + max(l, r);
    }
    bool check(TreeNode *node)
    {
        if(!node)   return true;
        int l = depth(node->left);
        int r = depth(node->right);
        if(abs(l-r) > 1)    return false;
        bool left = check(node->left);
        bool right = check(node->right);
        if(!left || !right) return false;
        return true;
    }
    int height(TreeNode *node)
    {
        if(!node) return 0;

        int l = height(node->left);
        int r = height(node->right);

        if(l == -1 || r == -1)  return -1;
        if(abs(l-r) > 1)    return -1;
        return 1 + max(l, r);
    }
    bool isBalanced(TreeNode* root) {
        TreeNode *node = root;
        //return check(node); O(n*n)
        if(height(node) == -1)  return false;   //Tc: O(n)
        return true;
    }
};