/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> answer = new ArrayList<>();
        if(root == null || target == null || k<0)
            return answer;
        Queue<TreeNode> levelorder = new LinkedList<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        levelorder.add(root);
        while(!levelorder.isEmpty()) {
            int size = levelorder.size();
            for(int i=1;i<=size;i++) {
                TreeNode parentnode = levelorder.poll();
                if(parentnode.left != null) {
                    levelorder.add(parentnode.left);
                    parent.put(parentnode.left, parentnode);
                }
                if(parentnode.right != null) {
                    levelorder.add(parentnode.right);
                    parent.put(parentnode.right, parentnode);
                }
            }
        }

        //From target we need to move up, left, right 
        int distance = 0;
        levelorder.add(target);
        visited.add(target);
        while(!levelorder.isEmpty()) {
            int size = levelorder.size();
            if(distance == k)
            {
                break;
            }
            for(int i=1;i<=size;i++) {
                TreeNode node = levelorder.poll();
                if(parent.containsKey(node) && visited.add(parent.get(node))) {
                    visited.add(parent.get(node));
                    levelorder.add(parent.get(node));
                }
                if(node.left != null && visited.add(node.left)) {
                    visited.add(node.left);
                    levelorder.add(node.left);
                }
                if(node.right != null && visited.add(node.right)) {
                    visited.add(node.right);
                    levelorder.add(node.right);
                }
            }
            distance++;
        }
        while(!levelorder.isEmpty()) {
            answer.add(levelorder.poll().val);
        }
        return answer;
    }
}