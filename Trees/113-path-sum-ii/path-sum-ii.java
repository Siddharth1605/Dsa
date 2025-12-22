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
    public static void helper(TreeNode root, int t, int sum, List<Integer> ds,
            List<List<Integer>> ans) {
        if(root == null)
            return;        
        if(root.left == null && root.right == null) {
            if(sum + root.val == t) {
                ds.add(root.val);
                ans.add(new ArrayList<>(ds));
                ds.remove(ds.size() - 1);
            }
            return;
        }
        ds.add(root.val);
        sum += root.val;
        helper(root.left, t, sum, ds, ans);
        helper(root.right, t, sum, ds, ans);
        sum -= root.val;
        ds.remove(ds.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(root, t, 0, ds, ans);
        return ans;
    }
}