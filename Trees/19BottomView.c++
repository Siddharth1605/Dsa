/************************************************************

    Following is the TreeNode class structure

    template <typename T>
    class TreeNode {
       public:
        T data;
        TreeNode<T> *left;
        TreeNode<T> *right;

        TreeNode(T data) {
            this->data = data;
            left = NULL;
            right = NULL;
        }
    };

************************************************************/
#include<bits/stdc++.h>
vector<int> bottomView(TreeNode<int> * root){
    // Write your code here.
    vector<int> ans;
    if(!root)   return ans;

    map<int, int> m;
    queue<pair<TreeNode<int> *, int>> q;

    q.push({root, 0});
    while(!q.empty())
    {
        auto temp = q.front();
        q.pop();

        TreeNode<int> *cur = temp.first;
        int x = temp.second;

        m[x] = cur->data;

        if(cur->left)   q.push({cur->left, x-1});
        if(cur->right)  q.push({cur->right, x+1});

    }
    for(auto it : m)    ans.push_back(it.second);

    return ans;
}
