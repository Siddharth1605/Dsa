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
    public void inorder(TreeNode root, int k, int c[], int ans[]) {
        if(root == null || c[0] >= k)
            return;
        
        inorder(root.left, k, c, ans);

        c[0] = c[0] + 1;
        if(c[0] == k){
            ans[0] = root.val;
            return;
        }
        
        inorder(root.right, k, c, ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] ans = {0};
        int[] c = {0};
        inorder(root, k, c, ans);
        return ans[0];
    }
}