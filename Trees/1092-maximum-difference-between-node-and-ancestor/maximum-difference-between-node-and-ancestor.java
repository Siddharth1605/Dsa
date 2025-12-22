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
    public static void postorder(TreeNode root, int max, int min, int[] ans) {
        if(root == null)
            return;
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        postorder(root.left, max, min, ans);
        postorder(root.right, max, min, ans);
        int answer = Math.max(Math.abs(max - root.val), Math.abs(min - root.val));
        ans[0] = Math.max(ans[0], answer);
    }
    public int maxAncestorDiff(TreeNode root) {
        int[] ans = {Integer.MIN_VALUE};
        postorder(root, Integer.MIN_VALUE, Integer.MAX_VALUE, ans);
        return ans[0];
    }
}