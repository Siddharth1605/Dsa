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
    public static int helper(TreeNode root, boolean isLeft) {
        if(root == null)
            return 0;
        int left = helper(root.left, true);
        int right = helper(root.right, false);
        if(root.left == null && root.right == null && isLeft)
            return root.val;
        return left + right;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }
}