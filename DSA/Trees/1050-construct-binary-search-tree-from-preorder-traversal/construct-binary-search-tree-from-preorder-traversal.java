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
    public static TreeNode bst(int[] preorder, int up, int[] i) {
        if(i[0] == preorder.length || preorder[i[0]] > up)
            return null;
        TreeNode root = new TreeNode(preorder[i[0]]);
        i[0]++;
        root.left = bst(preorder, root.val, i);
        root.right = bst(preorder, up, i);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, Integer.MAX_VALUE, new int[]{0});
    }
}