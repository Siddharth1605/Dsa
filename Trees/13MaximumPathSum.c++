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
    int fun(TreeNode *node, int &ans)
    {
        if(!node)   return 0;

        int l = max(0, fun(node->left, ans));
        int r = max(0, fun(node->right, ans));

        ans = max(ans, l + r + node->val);

        return node->val + max(l, r);
    }
    int maxPathSum(TreeNode* root) {
        TreeNode *node = root;
        int ans = INT_MIN;
        fun(node, ans);
        return ans;
    }
};