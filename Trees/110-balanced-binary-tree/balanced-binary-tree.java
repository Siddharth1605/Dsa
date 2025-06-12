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
    public static int getHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = 1 + getHeight(root.left);
        int right = 1 + getHeight(root.right);
        return Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftSubTreeHeight = getHeight(root.left);
        int rightSubTreeHeight = getHeight(root.right);
        if(Math.abs(leftSubTreeHeight - rightSubTreeHeight) <= 1) 
        {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }
}