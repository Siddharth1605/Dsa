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
class WidthData {
    TreeNode node;
    int index;
    public WidthData(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if(root == null)
            return ans;  
        Queue<WidthData> queue = new LinkedList<>();
        queue.add(new WidthData(root, 0));
        while(!queue.isEmpty()) {
            int size = queue.size();
            int minimumIndex = queue.peek().index;
            int firstIndex = 0;
            int lastIndex = 0;
            for(int i=1;i<=size;i++) {
                int currentIndex = queue.peek().index - minimumIndex;
                TreeNode node = queue.peek().node;
                queue.poll();
                if(node.left != null) {
                    queue.add(new WidthData(node.left, (currentIndex*2) + 1));
                }
                if(node.right != null) {
                    queue.add(new WidthData(node.right, (currentIndex*2) + 2));
                }
                if(i == 1) {
                    firstIndex = currentIndex;
                }
                if(i == size) {
                    lastIndex = currentIndex;
                }
            }
            ans = Math.max(ans, lastIndex - firstIndex + 1);
        }   
        return ans;
    }
}