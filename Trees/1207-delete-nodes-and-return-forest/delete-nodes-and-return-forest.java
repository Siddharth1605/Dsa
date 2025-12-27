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
    public static boolean isArrContains(int[] arr, int x) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == x)
                return true;
        }
        return false;
    }
    public static TreeNode delNodesHelper(TreeNode root, int[] to_delete, List<TreeNode> ans) {
        if(root == null)
            return null;
        root.left = delNodesHelper(root.left, to_delete, ans);
        root.right = delNodesHelper(root.right, to_delete, ans);
        if(isArrContains(to_delete, root.val)) {
            if(root.left != null) 
                ans.add(root.left);
            if(root.right != null)
                ans.add(root.right);
            return null;
        }
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        if(root == null)
            return ans;
        delNodesHelper(root, to_delete, ans);
        if(!isArrContains(to_delete, root.val)) 
            ans.add(root);
        return ans;
    }
}