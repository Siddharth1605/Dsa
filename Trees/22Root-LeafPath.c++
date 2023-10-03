/********************************************************************

    Following is the Binary Tree node structure:

    class BinaryTreeNode {
        public :
        int data;
        BinaryTreeNode<T> *left;
        BinaryTreeNode<T> *right;

        BinaryTreeNode(T data) {
            this -> data = data;
            left = NULL;
            right = NULL;
        }
    };
    
********************************************************************/
void fun(BinaryTreeNode<int> *root, string path, vector<string> &ds)
{
    if (!root) {
        return;
    }

    // Append the current node's data to the path
    path += to_string(root->data);

    if (!root->left && !root->right) {
        
        ds.push_back(path);
    }

    // Recursively traverse the left and right subtrees
    if (root->left) {
        fun(root->left, path + " ", ds);
    }
    if (root->right) {
        fun(root->right, path + " ", ds);
    }
}

vector <string> allRootToLeaf(BinaryTreeNode<int> * root) {
    string path = "";
    vector<string> ds;
    fun(root, path, ds);
    return ds;
}
