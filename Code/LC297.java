/////////////// sol 1: serialize -> StringBuilder, deserilaze -> Queue<String> q

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
        return seriHelper(new StringBuilder(), root).toString();
    }
    
    private StringBuilder seriHelper(StringBuilder sb, TreeNode root) {
        if (root == null) return sb.append("#");
        sb.append(root.val);
        sb.append("%");
        seriHelper(sb, root.left);
        sb.append("%");
        seriHelper(sb, root.right);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        return deseHelper(new LinkedList<>(Arrays.asList(data.split("%"))));
    }
    
    private TreeNode deseHelper(Queue<String> q) {
        String curVal = q.poll();
        if (curVal.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(curVal));
        root.left = deseHelper(q);
        root.right = deseHelper(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
