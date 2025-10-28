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
class BSTIterator {
    public Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        if(root != null)
            addNext(root);
    }
    
    public int next() {
        if(!hasNext()) 
            return -1;
        TreeNode top = stack.pop();
        addNext(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void addNext(TreeNode root) {
        if(root == null)
            return;
        stack.add(root);
        while(root.left != null) {
            stack.add(root.left);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */