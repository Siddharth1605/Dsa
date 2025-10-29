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
class BST {
    Stack<TreeNode> stack = new Stack<>();
    boolean asc = true;
    public BST(TreeNode root, boolean asc) {
        this.asc = asc;
        pushAll(root);
    }
    public int next() {
        if(stack.isEmpty())
            return Integer.MIN_VALUE;
        TreeNode top = stack.pop();
        if(asc == true)
            pushAll(top.right);
        else
            pushAll(top.left);
        return top.val;
    }
    public void pushAll(TreeNode root) {
        while(root != null) {
            stack.add(root);
            if(asc) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
    }
}
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;
        BST left = new BST(root, true);
        BST right = new BST(root, false);
        int i = left.next();
        int j = right.next();
        while(i < j) {
            int sum = i + j;
            if(sum == k) 
                return true;
            else if (sum < k)
                i = left.next();
            else 
                j = right.next();
            if(i == Integer.MIN_VALUE || j == Integer.MIN_VALUE)
                return false;
        }
        return false;
    }
}