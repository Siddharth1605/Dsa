/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        Queue<TreeNode> levelorder = new LinkedList<>();
        StringBuilder str = new StringBuilder();
        levelorder.add(root);
        while(!levelorder.isEmpty()) {
            TreeNode node = levelorder.poll();
            if(node == null) {
                str.append("#,");
                continue;
            }
            str.append(node.val + ",");
            levelorder.add(node.left);
            levelorder.add(node.right);
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        for(int i=1;i<values.length;i++) {
            TreeNode node = queue.poll();
            if(!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(left);
                node.left = left;
            }
            if(!values[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(right);
                node.right = right;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));