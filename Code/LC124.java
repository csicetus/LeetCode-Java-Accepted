///////////// sol 1: recursion/DFS

// Time: O(n)? postorder of BST; Space: O(1)
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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        dfs(root, res);
        return res[0];
    }
    
    
    private int dfs(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int leftVal = dfs(root.left, res);
        int rightVal = dfs(root.right, res);
        if (leftVal < 0) leftVal = 0;
        if (rightVal < 0) rightVal = 0;
        res[0] = Math.max(res[0], (root.val + leftVal + rightVal));
        return (root.val + Math.max(leftVal, rightVal));
    }
}
