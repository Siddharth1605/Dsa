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
    public static int[] avgHelper(TreeNode root, int[] c) {
    if (root == null)
        return new int[]{0, 0};

    int[] left = avgHelper(root.left, c);
    int[] right = avgHelper(root.right, c);

    int childSum = left[0] + right[0];
    int childCount = left[1] + right[1];

    int totalSum = childSum + root.val;
    int totalCount = childCount + 1;

    if (totalSum / totalCount == root.val)
        c[0]++;

    return new int[]{totalSum, totalCount};
}

    public int averageOfSubtree(TreeNode root) {
        if(root == null)
            return 0;
        int[] c = {0};
        avgHelper(root, c);
        return c[0];
    }
}