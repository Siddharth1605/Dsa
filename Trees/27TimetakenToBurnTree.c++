/************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode 
    {
        public : 
        T data;
        BinaryTreeNode<T> *left;
        BinaryTreeNode<T> *right;

        BinaryTreeNode(T data) 
        {
            this -> data = data;
            left = NULL;
            right = NULL;
        }
    };

************************************************************/
#include<bits/stdc++.h>
void parentsMap(BinaryTreeNode<int> *root, unordered_map<BinaryTreeNode<int> *,BinaryTreeNode<int> *> &parents)
{
    queue<BinaryTreeNode<int> *> q;
    q.push(root);
    while(!q.empty())
    {
        BinaryTreeNode<int> *cur = q.front();
        q.pop();
        if(cur->left)
        {
            parents[cur->left] = cur;
            q.push(cur->left);
        }
        if(cur->right)
        {
            parents[cur->right] = cur;
            q.push(cur->right);
        }
    }
}
int time(BinaryTreeNode<int> *root, BinaryTreeNode<int> *target)
{
    queue<BinaryTreeNode<int> *> q;
    q.push(target);
    unordered_map<BinaryTreeNode<int> *, BinaryTreeNode<int> *> parents;
    parentsMap(root, parents);

    unordered_map<BinaryTreeNode<int> *, bool> visited;
    visited[target] = true;

    int t = 0;
    while(!q.empty())
    {
        int n = q.size();
        bool flag = true;
        for(int i=0;i<n;i++)
        {
            BinaryTreeNode<int> *cur = q.front();
            q.pop();
            if(cur->left && !visited[cur->left])
            {
                flag = true;
                q.push(cur->left);
                visited[cur->left] = true;
            }
            if(cur->right && !visited[cur->right])
            {
                flag = true;
                q.push(cur->right);
                visited[cur->right] = true;
            }
            if(parents[cur] && !visited[parents[cur]])
            {
                flag = true;
                q.push(parents[cur]);
                visited[parents[cur]] = true;
            }
        }
        if(flag)    t++;
    }
    return t - 1;
}
BinaryTreeNode<int> *findNode(BinaryTreeNode<int> *node, int t)
{
    if(!node)   return NULL;
    if(node-> data == t) return node;
    BinaryTreeNode<int> *nodeleft = findNode(node->left, t);
    BinaryTreeNode<int> *noderight = findNode(node->right, t);   
    if(nodeleft)    return nodeleft;
    return noderight;
} 
int timeToBurnTree(BinaryTreeNode<int>* root, int start)
{
    // Write your code here
    BinaryTreeNode<int> *target = findNode(root, start);
    return time(root, target);
}
