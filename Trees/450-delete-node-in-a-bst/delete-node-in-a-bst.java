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

class Bst
{
    public TreeNode delete(TreeNode root, int key)
    {
        if(root == null)
            return null;
        
        if(root.val > key)
        {
            root.left = delete(root.left, key);
            return root;
        }
        else if(root.val < key)
        {
            root.right = delete(root.right, key);
            return root;
        }
        else
        {
            if(root.right == null && root.left == null)
                return null;
            if(root.right == null)
                return root.left;
            if(root.left == null)
                return root.right;
            TreeNode temp = root.right;
            TreeNode prev = root.right;
            while(temp.left != null)
            {
                prev = temp;
                temp = temp.left;
            }

            root.val = temp.val;
            //prev.left = temp.right;
            root.right = delete(root.right, temp.val);
            return root;
        }
    }
}
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        Bst obj = new Bst();
        return obj.delete(root, key);
    }
}