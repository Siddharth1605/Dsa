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
    public static int rootPathSum(TreeNode root, int t, long sum) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return (sum + root.val == t) ? 1 : 0;
        //if nodes are not-negative we can return after below statement
        //but if they may be negative, then we dont stop
        int count = (sum + root.val == t) ? 1 : 0;
        int leftPath = rootPathSum(root.left, t, sum + root.val);
        int rightPath = rootPathSum(root.right, t, sum + root.val);
        return count + leftPath + rightPath;
    }
    public static int brute(TreeNode root, int t) {
        if(root == null)
            return 0;
        int pathSum = rootPathSum(root, t, 0);
        int left = brute(root.left, t);
        int right = brute(root.right, t);
        return pathSum + left + right;
    }

    public static int optimised(TreeNode root, int t, long sum, Map<Long, Integer> map)    {
        if(root == null)
            return 0;
        sum += root.val;
        int count = map.getOrDefault(sum - t, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        count += optimised(root.left, t, sum, map);
        count += optimised(root.right, t, sum, map);
        map.put(sum, map.get(sum) - 1);
        if(map.get(sum) == 0)
            map.remove(sum);
        return count;
    }
    public int pathSum(TreeNode root, int t) {
        Map<Long, Integer> map = new HashMap<>();
        long zero = 0;
        map.put(zero, 1);
        return optimised(root, t, 0, map);
    }
}