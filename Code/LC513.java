//////////// sol 1: BFS

// Time: O(n); Space: O(n)
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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            root = q.poll();
            // first right then left
            // the last one is leftmost of bottom
            if (root.right != null) {
                q.offer(root.right);
            }
            if (root.left != null) {
                q.offer(root.left);
            }
        }
        return root.val;
    }
}
