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
    public static TreeNode build(int[] inorder, int[] postorder, int n, Map<Integer, Integer> in_hash, TreeNode root, int in_start, int in_end, int post_start, int post_end) {
        if(post_start > post_end || in_start > in_end) 
            return null;
        root = new TreeNode(postorder[post_end]);
        int in_index = in_hash.get(postorder[post_end]);
        int in_leftstart = in_start;
        int in_leftend = in_index - 1;
        int in_rightstart = in_index + 1;
        int in_rightend = in_end;
        int post_rightend = post_end - 1;
        int post_rightstart = post_end - (in_rightend - in_rightstart) - 1;
        int post_leftstart = post_start;
        int post_leftend = post_rightstart - 1;
        root.left = build(inorder, postorder, n, in_hash, root.left, in_leftstart, in_leftend, post_leftstart, post_leftend);
        root.right = build(inorder, postorder, n, in_hash, root.right, in_rightstart, in_rightend, post_rightstart, post_rightend);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> in_hash = new HashMap<>();
        int n = inorder.length;
        for(int i=0;i<n;i++) {
            in_hash.put(inorder[i], i);
        }        
        TreeNode root = new TreeNode(postorder[n-1]);
        return build(inorder, postorder, n, in_hash, root, 0, n-1, 0, n-1);
    }
}