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
    void inorder(TreeNode *root, vector<int> &inlist)
    {
        if(!root)   return;
        inorder(root->left, inlist);
        inlist.push_back(root->val);
        inorder(root->right, inlist);
    }
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> inlist;
        //inorder(root, inlist);

        stack<TreeNode *> st;
        TreeNode *node = root;
        while(true)
        {
            if(node)
            {
                st.push(node);
                node = node->left;
            }
            else
            {
                if(st.empty())  break;
                node = st.top();
                st.pop();
                inlist.push_back(node->val);
                node = node->right;
            }
        }
        return inlist;
    }
};