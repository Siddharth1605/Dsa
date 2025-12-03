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
    public TreeNode helper(TreeNode root, int val) {
       if(root == null)
            return null;
        if(root.val < val) 
            root.right = helper(root.right, val);
        else if(root.val > val)
            root.left = helper(root.left, val);
        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            TreeNode temp = root.right;
            while(temp.left != null) {
                temp = temp.left;
            }
            root.val = temp.val;
            root.right = helper(root.right, temp.val);
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        return helper(root, key);
    }
}