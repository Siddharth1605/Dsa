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
    int heightLeft(TreeNode *root)
    {
        int h = 0;
        while(root)
        {
            h++;
            root = root->left;
        }
        return h;
    }
    int heightRight(TreeNode *root)
    {
        int h = 0;
        while(root)
        {
            h++;
            root = root->right;
        }
        return h;
    }
    int countNodes(TreeNode* root) {
        if(!root)   return 0;

        int l = heightLeft(root);
        int r = heightRight(root);

        if(l == r)  return pow(2,l)-1;

        return 1 + countNodes(root->left) + countNodes(root->right);
    }
};