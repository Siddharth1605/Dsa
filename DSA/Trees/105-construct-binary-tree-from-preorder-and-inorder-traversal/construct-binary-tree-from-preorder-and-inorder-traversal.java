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
    public static TreeNode build(Map<Integer, Integer> inorderHash, int[] inorder, int[] preorder, int instart, int inend, int prestart, int preend) {

        if(prestart > preend || instart > inend)
            return null;
        TreeNode root = new TreeNode(preorder[prestart]);
        int inindex = inorderHash.get(preorder[prestart]);
        int left_instart = instart;
        int left_inend = inindex - 1;
        int right_instart = inindex + 1;
        int right_inend = inend;
        int left_prestart = prestart + 1;
        int left_preend = prestart + (left_inend - left_instart + 1);
        int right_prestart = left_preend + 1;
        int right_preend = preend;
        
        root.left = build(inorderHash, inorder, preorder, left_instart, left_inend, left_prestart, left_preend);
        root.right = build(inorderHash, inorder, preorder, right_instart, right_inend, right_prestart, right_preend);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> inorderHash = new HashMap<>();
        for(int i=0;i<n;i++)
            inorderHash.put(inorder[i], i);
        TreeNode root = build(inorderHash, inorder, preorder, 0, n-1, 0, n-1);
        return root;
    }
}