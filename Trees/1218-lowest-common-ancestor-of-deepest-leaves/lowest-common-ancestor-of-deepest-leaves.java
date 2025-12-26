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
class Pair {
    TreeNode node;
    int depth;
    public Pair(TreeNode node, int depth) {
        this.depth = depth;
        this.node = node;
    }
}
class Solution {
    public static Pair helper(TreeNode root) {
        if(root == null) {
            return new Pair(null, 0);
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        if(left.depth == right.depth)
            return new Pair(root, left.depth + 1);
        else if(left.depth > right.depth)
            return new Pair(left.node, left.depth + 1);
        else 
            return new Pair(right.node, right.depth + 1);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
       return helper(root).node;
    }
}