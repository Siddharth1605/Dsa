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
class Solution {
    public static TreeNode prune(TreeNode root) {
        if(root == null)
            return null;
        root.left = prune(root.left);
        root.right = prune(root.right);
        if(root.left == null && root.right == null && root.val == 0)
        {
            return null;
        }
        return root;
    }
    public TreeNode pruneTree(TreeNode root) {
        if(root == null)
            return null;
        return prune(root);
    }
}