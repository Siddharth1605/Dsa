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
    public TreeNode balance(TreeNode root, List<Integer> arr, int s, int e) {
        if(s>e || s<0 || e>=arr.size())
            return null;
        int midIndex = s + (e-s)/2;
        root = new TreeNode(arr.get(midIndex));
        int ls = s;
        int le = midIndex - 1;
        int rs = midIndex + 1;
        int re = e;
        root.left = balance(root.left, arr, ls, le);
        root.right = balance(root.right, arr, rs, re);
        return root;
    }
    public void inorderTraversal(TreeNode root, List<Integer> arr) {
        if(root == null)
            return;
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inorderTraversal(root, arr);
        TreeNode node = null;
        return balance(node, arr, 0, arr.size() - 1);
        
    }
}