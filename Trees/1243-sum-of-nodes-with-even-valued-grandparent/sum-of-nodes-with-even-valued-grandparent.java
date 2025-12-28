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
    public static int sumHelper(TreeNode root, TreeNode gp, TreeNode p)    {
        if(root == null)
            return 0;
        int count = 0;
        count += sumHelper(root.left, p, root);
        count += sumHelper(root.right, p, root);
        if(gp != null && gp.val % 2 == 0)
            count+=root.val;
        return count;
    }
    public int sumEvenGrandparent(TreeNode root) {
        return sumHelper(root, null, null);
    }
}