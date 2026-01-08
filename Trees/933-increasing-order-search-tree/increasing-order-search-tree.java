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
    public static void bruteincreasingBST(TreeNode node, TreeNode[] nodes) {
        if(node == null)
            return;
        bruteincreasingBST(node.left, nodes);
        if(nodes[1] == null)
            nodes[1] = node;
        if(nodes[0] != null){
            nodes[0].right = node;
            nodes[0].left = null;}
        nodes[0] = node;
        bruteincreasingBST(node.right, nodes);
    }
    public TreeNode increasingBST(TreeNode root) {
        TreeNode[] nodes = new TreeNode[3];
        bruteincreasingBST(root, nodes);
        nodes[0].left = null;
        nodes[0].right = null;
        return nodes[1];
    }
}