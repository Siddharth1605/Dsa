/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Bst
{
    public TreeNode insertNode(TreeNode root, int data)
    {
        TreeNode cur = new TreeNode(data);
        if(root == null)
            return cur;
        if(root.val < data)
            root.right = insertNode(root.right, data);
        else
            root.left = insertNode(root.left, data);
        return root;
    }
}
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        Bst obj = new Bst();
        root = obj.insertNode(root, val);
        return root;
    }
}