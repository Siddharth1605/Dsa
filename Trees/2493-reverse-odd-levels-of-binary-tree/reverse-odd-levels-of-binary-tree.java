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
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null)
            return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        List<Integer> arr = new ArrayList<>();
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(level % 2 == 1)
                arr = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                    if(level % 2 == 1) 
                        arr.add(node.left.val);
                }
                if(node.right != null) {
                    queue.add(node.right);
                    if(level % 2 == 1)
                        arr.add(node.right.val);
                }
                if(level % 2 == 0)
                    node.val = arr.get(size - i - 1);
            }
            level++;
        }
        return root;
    }
}