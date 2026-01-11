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
    public void helper(TreeNode root, int[] sum) {
        if(root == null)
            return;
        helper(root.right, sum);
        root.val += sum[0];
        sum[0] = root.val;
        helper(root.left, sum);
        // System.out.println("**********");
        // System.out.println("will return : " + x);
        // System.out.println("root.val : " + root.val);
        // root.val = root.val + right;
        // System.out.println("Updated root.val : " + root.val);
        // System.out.println("**********");
    }
    public TreeNode bstToGst(TreeNode root) {
        int[] sum = {0};
        helper(root, sum);
        return root;
    }
}