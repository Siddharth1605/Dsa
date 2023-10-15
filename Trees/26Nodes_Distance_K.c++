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
    void parentsmap(TreeNode *root, unordered_map<TreeNode *, TreeNode *> &parentsCheck)
    {
        queue<TreeNode *> q;
        q.push(root);
        while(!q.empty())
        {
            TreeNode *cur = q.front();
            q.pop();

            if(cur->left)
            {
                q.push(cur->left);
                parentsCheck[cur->left] = cur;
            }
            if(cur->right)
            {
                q.push(cur->right);
                parentsCheck[cur->right] = cur;
            }
        }

    }
   vector<int> distanceK(TreeNode* root, TreeNode* target, int k) {
    unordered_map<TreeNode *, TreeNode *> parentsCheck;
    parentsmap(root, parentsCheck);
    queue<TreeNode *> q;
    q.push(target);            
    vector<int> resl;
    unordered_map<TreeNode *, bool> visited;
    visited[target] = true;  // Mark the target node as visited
    int dis = 0;
    
    while (!q.empty()) {
        if (dis == k) {
            while (!q.empty()) {
                TreeNode *temp = q.front();
                q.pop();
                resl.push_back(temp->val);
            }
            return resl;
        }
        dis++;
        int n = q.size();
        for (int i = 0; i < n; i++) {
            TreeNode *cur = q.front();
            q.pop();
            if (cur->left && !visited[cur->left]) {
                q.push(cur->left);
                visited[cur->left] = true;
            }
            if (cur->right && !visited[cur->right]) {
                q.push(cur->right);
                visited[cur->right] = true;
            }
            TreeNode *parent = parentsCheck[cur];
            if (parent && !visited[parent]) {
                q.push(parent);
                visited[parent] = true;
            }
        }
    }
    
    return resl;
}

};