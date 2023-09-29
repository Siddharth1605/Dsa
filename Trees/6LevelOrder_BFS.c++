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
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        queue<TreeNode*> q;

        if(!root)   return ans;

        q.push(root);

        while(!q.empty())
        {
            int n = q.size();
            vector<int> cl(0, n);
            for(int i=0;i<n;i++)
            {
                TreeNode *cur = q.front();
                cl.push_back(cur->val);
                
                if(cur->left)    q.push(cur->left);
                if(cur->right)  q.push(cur->right);

                q.pop();
            }
            ans.push_back(cl);
        }
        return ans;
    }
};