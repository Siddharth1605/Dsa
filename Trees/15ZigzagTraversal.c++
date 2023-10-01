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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> ans;

        if(!root)   return ans;
        queue<TreeNode *> q;
        q.push(root);

        bool flag = true;
        while(!q.empty())
        {            
            int n = q.size();
            vector<int> curlevel(n);
            for(int i=0;i<n;i++)
            {
                TreeNode *temp = q.front();
                q.pop();
                int ind = (flag) ? i : (n - 1 -i);
                curlevel[ind] = temp->val;

                if(temp->left) q.push(temp->left);
                if(temp->right) q.push(temp->right);    
            }
            flag = !flag;
            ans.push_back(curlevel);
        }
        return ans;
    }
};