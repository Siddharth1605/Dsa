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
    //The approach is not to actually distribute coins or change node's val.
    //But to calculate how much coins each node contains additionally and how much coins each node requires additionally 
    public static int solve(TreeNode root, int[] moves) {
        if(root == null)   
            return 0;
        int left = solve(root.left, moves);
        int right = solve(root.right, moves);
        moves[0] += Math.abs(left) + Math.abs(right);
        int requirement = root.val+ (left + right) - 1;
        return requirement;
    }
    public int distributeCoins(TreeNode root) {
        int[] moves = {0};
        solve(root, moves);
        return moves[0];
    }
}