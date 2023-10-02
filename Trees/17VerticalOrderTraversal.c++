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
    vector<vector<int>> verticalTraversal(TreeNode* root) {
        vector<vector<int>> ans;
        if(!root)   return ans;

        queue<pair<TreeNode *, pair<int, int>>> q;
        map<int, map<int, multiset<int>>> nodevalues;
        q.push({root, {0,0}});

        while(!q.empty())
        {
            auto temp = q.front();
            q.pop();
            TreeNode *cur = temp.first;

            int x=temp.second.first;
            int y = temp.second.second;
            nodevalues[x][y].insert(cur->val);

            if(cur->left)   q.push({cur->left, {x-1, y+1}});
            if(cur->right) q.push({cur->right, {x+1, y+1}});
        }

        for(auto it : nodevalues)
        {
            vector<int> val;
            for(auto i : it.second)
            {
                val.insert(val.end(), i.second.begin(), i.second.end());
            }
            ans.push_back(val);
        }

        return ans;
    }
};