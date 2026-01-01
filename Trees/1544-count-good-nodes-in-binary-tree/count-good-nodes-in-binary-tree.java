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
    public static int helper(TreeNode root, int max){
        if(root == null)
            return 0;
        int c = 0;
        if(max <= root.val){
            c++;
            max = root.val;
        }
        c += helper(root.left, max);
        c += helper(root.right, max);
        return c;
    }
    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }
}