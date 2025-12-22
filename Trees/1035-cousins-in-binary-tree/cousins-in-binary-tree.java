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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, TreeNode> parents = new HashMap<>();
        queue.add(root);
        while(!queue.isEmpty()) 
        {
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;
            for(int i=0;i<size;i++) {
                TreeNode top = queue.poll();
                if(top.left != null) {
                    parents.put(top.left.val, top);
                    queue.add(top.left);
                }
                if(top.right != null) { 
                    parents.put(top.right.val, top);
                    queue.add(top.right);
                }
                if (top.val == x) foundX = true;
                if (top.val == y) foundY = true;
                if(foundX && foundY && (parents.get(x) != parents.get(y)))
                    return true;
            }
            
        }
        return false;
    }
}