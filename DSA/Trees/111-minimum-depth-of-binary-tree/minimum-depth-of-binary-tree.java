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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        int leftHeight = 10000;
        int rightHeight = 10000;
        if(root.left != null)
            leftHeight = minDepth(root.left);
        if(root.right != null) 
            rightHeight = minDepth(root.right);
        return 1 + Math.min(leftHeight, rightHeight);
    }
}