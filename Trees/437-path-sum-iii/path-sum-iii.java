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
    public static int rootPathSum(TreeNode root, int t, long sum) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return (sum + root.val == t) ? 1 : 0;
        //if nodes are not-negative we can return after below statement
        //but if they may be negative, then we dont stop
        int count = (sum + root.val == t) ? 1 : 0;
        int leftPath = rootPathSum(root.left, t, sum + root.val);
        int rightPath = rootPathSum(root.right, t, sum + root.val);
        return count + leftPath + rightPath;
    }
    public int pathSum(TreeNode root, int t) {
        if(root == null)
            return 0;
        int pathSum = rootPathSum(root, t, 0);
        int left = pathSum(root.left, t);
        int right = pathSum(root.right, t);
        return pathSum + left + right;
    }
}