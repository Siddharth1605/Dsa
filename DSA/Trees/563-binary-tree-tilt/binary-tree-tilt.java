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
    public static int helper(TreeNode root, int[] sum) {
        if(root == null)
            return 0;
        int sumOfLeftSubTree = helper(root.left, sum);
        int sumOfRightSubTree = helper(root.right, sum);
        sum[0] += Math.abs(sumOfLeftSubTree - sumOfRightSubTree);
        return root.val + sumOfLeftSubTree + sumOfRightSubTree;
    }
    public int findTilt(TreeNode root) {
        int[] sum = {0};
        helper(root, sum);
        return sum[0];
    }
}