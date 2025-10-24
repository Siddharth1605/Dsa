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
    public static boolean valid(TreeNode root, long low, long high)
    {
        if(root == null)
            return true;
        if(root.val >= high || root.val <= low)
            return false;
        boolean left = valid(root.left, low, root.val);
        if(left == false)
            return false;
        boolean right = valid(root.right, root.val, high);
        if(right == false)
            return false;
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}