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
    public void inorder(TreeNode root, TreeNode[] arr) {
        if(root == null)
            return;
        inorder(root.left, arr);
        if(arr[3] != null && arr[0] == null && arr[3].val > root.val) {
            arr[0] = arr[3];
            arr[1] = root;
        }
        else if (arr[3] != null && arr[3].val > root.val) {
            arr[2] = root;
        }
        arr[3] = root;
        inorder(root.right, arr);
    }
    public void recoverTree(TreeNode root) {
        TreeNode[] arr = new TreeNode[4];
        arr[0] = arr[1] = arr[2] = null;
        arr[3] = new TreeNode(Integer.MIN_VALUE);
        inorder(root, arr);
        if(arr[0] != null && arr[2] != null) {
            int temp = arr[0].val;
            arr[0].val = arr[2].val;
            arr[2].val = temp;
        } else if(arr[0] != null && arr[1] != null) {
            int temp = arr[0].val;
            arr[0].val = arr[1].val;
            arr[1].val = temp;
        }
    }
}