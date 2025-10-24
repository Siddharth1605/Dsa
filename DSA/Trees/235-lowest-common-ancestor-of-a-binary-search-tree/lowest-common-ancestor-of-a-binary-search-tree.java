/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public static TreeNode whileSolution(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        while(root != null) {
            if(root.val > q.val && root.val > p.val)
                root = root.left;
            else if(root.val < q.val && root.val < p.val)
                root = root.right;
            else
                return root;
        }
        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if(root == null)
        //     return root;
        // if(root.val > q.val && root.val > p.val)
        //     return lowestCommonAncestor(root.left, p, q);
        // if(root.val < p.val && root.val < q.val)
        //     return lowestCommonAncestor(root.right, p, q);
        // return root;
        return whileSolution(root, p, q);
    }
}