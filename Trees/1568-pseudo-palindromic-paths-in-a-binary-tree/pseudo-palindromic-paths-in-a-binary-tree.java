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
    public static int brutePalindrome(TreeNode root, Map<Integer, Integer> map) {
        if(root == null)
            return 0;
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        int c = 0;
        if(root.left == null && root.right == null) {
            int odd = 0;
            //Not more than one element should come with odd frequencies
            for (int v : map.values()) {
                if (v % 2 != 0) odd++;
            }
            if (odd <= 1) c++;
        } else {
            c += brutePalindrome(root.left, map);
            c += brutePalindrome(root.right, map);
        }
        map.put(root.val, map.get(root.val) - 1);
        if(map.get(root.val) == 0) {
            map.remove(root.val);
        }
        return c;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        if(root == null)
            return 0;
        return brutePalindrome(root, map);
    }
}