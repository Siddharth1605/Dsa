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
    int fun(TreeNode *root)
    {
        long long ans = 0;
        if(!root)   return ans;

        queue<pair<TreeNode *, long long>> q;
        q.push({root, 0});

        while(!q.empty())
        {
            int n = q.size();
            long long mmin = q.front().second;
            long long first = 0;
            long long last = 0;
            for(int i=0;i<n;i++)
            {
                long long curid = q.front().second - mmin;
                TreeNode *cur = q.front().first;
                q.pop();

                if(i == 0)  first = curid;
                else if(i == n-1)   last = curid;

                if(cur->left)   q.push({cur->left, curid * 2 +1});
                if(cur->right)  q.push({cur->right, curid * 2 +2});
            }

            ans = max(ans, last - first + 1);
        }
        return ans;
    }
    int widthOfBinaryTree(TreeNode* root) {
        return fun(root);
    }
};